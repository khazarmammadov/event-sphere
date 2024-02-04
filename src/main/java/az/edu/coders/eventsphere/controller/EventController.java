package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.dto.response.EventResponse;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Controller
public class EventController {

    private final EventService eventService;
    private final TransactionService transactionService;

    @PostMapping
    public void saveEvent(@RequestBody CreatedEventRequest request) {
        eventService.saveEvent(request);
    }

    @GetMapping("/{id}")
    public EventDetailsResponse getDetailsById(@PathVariable Long id) {
        return eventService.getDetailsById(id);
    }

    @GetMapping()
    public List<EventDetailsResponse> getEventByStatus(@RequestParam EventStatus status) {
        return eventService.getEventByStatus(status);
    }

    @PostMapping("/transaction")
    public void createTransaction(@RequestBody CreatedTransactionRequest request) {
        transactionService.createTransaction(request);
    }


    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody UpdatedEventRequest request) {
        eventService.updateEvent(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
