package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.model.request.CreatedEventRequest;
import az.edu.coders.eventsphere.model.request.CreatedReviewRequest;
import az.edu.coders.eventsphere.model.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.model.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.model.response.EventDetailsResponse;
import az.edu.coders.eventsphere.model.response.EventResponse;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.ReviewService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final ReviewService reviewService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public void saveEvent(@RequestPart("data") CreatedEventRequest request,
                          @RequestPart("file") MultipartFile file) {
        eventService.saveEvent(request, file);
    }

    @GetMapping("/{id}")
    public EventDetailsResponse getDetailsById(@PathVariable Long id) {
        return eventService.getDetailsById(id);
    }

    @GetMapping()
    public List<EventResponse> getEventByStatus(@RequestParam EventStatus status) {
        return eventService.getEventByStatus(status);
    }

    @PostMapping("/transaction")
    public void getDetailsById(@RequestBody CreatedTransactionRequest request) {
        eventService.createTransaction(request);
    }


    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody UpdatedEventRequest request) {
        eventService.updateEvent(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping(value = "/{id}/picture/show")
    public ResponseEntity<byte[]> downloadPicture(@PathVariable Long id, HttpServletResponse response) throws Exception{
        InputStream inputStream = eventService.getEventPictureById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(inputStream.readAllBytes());
    }

    @PostMapping(value = "/{eventId}/reviews")
    public void addReview(@RequestBody CreatedReviewRequest reviewRequest, @PathVariable Long eventId) {
        reviewService.addReview(reviewRequest, eventId);
    }

}
