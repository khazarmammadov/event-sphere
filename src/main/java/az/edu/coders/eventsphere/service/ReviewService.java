package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.model.dto.request.CreatedReviewRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    void addReview(CreatedReviewRequest reviewRequest, Long eventId);
    Page<Review> getAllReviews(Pageable pageable);
}