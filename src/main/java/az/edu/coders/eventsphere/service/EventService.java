package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.model.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.model.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.model.dto.response.EventResponse;
import az.edu.coders.eventsphere.enumurated.EventStatus;

import java.util.List;

public interface EventService {
    void saveEvent(CreatedEventRequest request);
    void updateEvent(Long id, UpdatedEventRequest request);
    void deleteEvent(Long id);
    List<EventResponse> getEventByStatus(EventStatus status);
    EventDetailsResponse getDetailsById(Long id);
    void createTransaction(CreatedTransactionRequest request);
}
