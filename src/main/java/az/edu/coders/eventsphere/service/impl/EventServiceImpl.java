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
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TransactionService transactionService;

    @Override
    public void saveEvent(CreatedEventRequest request) {
        Event event = eventMapper.toEntity(request);
        eventRepository.save(event);
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

        transactionService.createTransaction(event, request);
    }
}
