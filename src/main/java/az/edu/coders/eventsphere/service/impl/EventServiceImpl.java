package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.model.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.model.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.model.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.model.dto.response.EventResponse;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.mapper.EventMapper;
import az.edu.coders.eventsphere.repository.EventRepository;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.MinioService;
import az.edu.coders.eventsphere.service.TransactionService;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TransactionService transactionService;
    private final MinioService minioService;

    private static final String bucketName = "event-pictures";

    @Override
    public void saveEvent(CreatedEventRequest request, MultipartFile file) {
        Event event = eventMapper.toEntity(request);
        System.out.println("file; " + file.getName() + " - " + file.getOriginalFilename());


        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + "." + extension;

        try {
            minioService.putObject(file.getInputStream(), bucketName, fileName, "JPEG");
            event.setPicturePath(bucketName + "/" + fileName);
            eventRepository.save(event);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Long id, UpdatedEventRequest request) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        eventMapper.updateEntity(event, request);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        event.setStatus(EventStatus.DELETED);
        eventRepository.save(event);
    }

    @Override
    public List<EventResponse> getEventByStatus(EventStatus status) {
        List<Event> eventList = eventRepository.findAllByStatus(status);

        return eventList.stream()
                .map(eventMapper::toEventResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EventDetailsResponse getDetailsById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));

        return eventMapper.toEventDetailsResponse(event);
    }

    @Override
    public void createTransaction(CreatedTransactionRequest request) {
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + request.getEventId()));
        System.out.println("alma");
        if (request.getQuantity() < event.getRestOfPlace()) {
            transactionService.createTransaction(event, request);
            updateRestOfPlace(event.getId(), request.getQuantity());
            System.out.println("alma");
        } else {
            throw new RuntimeException("Only " + event.getRestOfPlace() + " available");
        }

    }

    @Override
    public InputStream getEventPictureById(Long id) {
        try {
            EventDetailsResponse event = getDetailsById(id);
            String picturePath = event.getPicturePath();
            if (picturePath != null) {
                String[] split = picturePath.split("/");
                if (split.length == 2) {
                    String bucketName = split[0];
                    String filename = split[1];
                    return minioService.getObject(bucketName, filename);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Invalid file operation!");
    }

    @Override
    public void updateRestOfPlace(Long eventId, int count) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + eventId));
        event.setRestOfPlace(event.getRestOfPlace() - count);
        eventRepository.save(event);
    }

    @Override
    public Event findEventById(Long eventId) {
        return eventRepository.findEventById(eventId).orElseThrow(
                () -> new RuntimeException("Event Not Found by given id: " + eventId));
    }

}
