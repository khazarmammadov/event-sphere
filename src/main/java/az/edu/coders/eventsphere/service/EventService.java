package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.dto.response.EventResponse;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.mapper.EventMapper;
import az.edu.coders.eventsphere.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TransactionService transactionService;

    public void saveEvent(CreatedEventRequest request) {
        Event event = eventMapper.toEntity(request);
        eventRepository.save(event);
    }

    public void updateEvent(Long id, UpdatedEventRequest request) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        eventMapper.updateEntity(event, request);
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        event.setStatus(EventStatus.DELETED);
        eventRepository.save(event);
    }

    public List<EventResponse> getEventByStatus(EventStatus status) {
        List<Event> eventList = eventRepository.findAllByStatus(status);

        return eventList.stream()
                .map(eventMapper::toEventResponse)
                .collect(Collectors.toList());

    }

    public EventDetailsResponse getDetailsById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));

        return eventMapper.toEventDetailsResponse(event);
    }


    public void createTransaction(CreatedTransactionRequest request) {
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + request.getEventId()));

        transactionService.createTransaction(event, request);
    }
}
