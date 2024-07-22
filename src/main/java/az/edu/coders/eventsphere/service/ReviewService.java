package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.model.request.CreatedReviewRequest;
import az.edu.coders.eventsphere.model.response.ReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    void addReview(CreatedReviewRequest reviewRequest, Long eventId);
    Page<ReviewResponse> getAllReviews(Pageable pageable);
}
