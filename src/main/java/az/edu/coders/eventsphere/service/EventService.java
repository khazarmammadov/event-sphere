package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.model.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.model.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.model.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.model.dto.response.EventResponse;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface EventService {
    void saveEvent(CreatedEventRequest request, MultipartFile file);
    void updateEvent(Long id, UpdatedEventRequest request);
    void deleteEvent(Long id);
    List<EventResponse> getEventByStatus(EventStatus status);
    EventDetailsResponse getDetailsById(Long id);
    void createTransaction(CreatedTransactionRequest request);
    InputStream getEventPictureById(Long id);
    void updateRestOfPlace(Long eventId, int count);
    Event findEventById(Long eventId);
}
