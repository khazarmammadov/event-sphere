package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.mapper.EventMapper;
import az.edu.coders.eventsphere.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

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

    public EventDetailsResponse getDetailsById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));

        return eventMapper.toEventDetailsResponse(event);
    }


}
