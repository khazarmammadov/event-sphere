package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Controller
public class EventController {

    private final EventService eventService;

    @PostMapping
    public void saveEvent(@RequestBody CreatedEventRequest request) {
        eventService.saveEvent(request);
    }

    @GetMapping("/{id}")
    public EventDetailsResponse getDetailsById(@PathVariable Long id) {
        return eventService.getDetailsById(id);
    }

    @PutMapping("/update/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody UpdatedEventRequest request) {
        eventService.updateEvent(id, request);
    }

    @PutMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
