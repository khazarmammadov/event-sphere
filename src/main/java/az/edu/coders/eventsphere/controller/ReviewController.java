package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.model.response.ReviewResponse;
import az.edu.coders.eventsphere.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    @GetMapping()
    private Page<ReviewResponse> getAllReviews(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size ) {
        Pageable pageable = PageRequest.of(page, size);

        return reviewService.getAllReviews(pageable);
    }
}
