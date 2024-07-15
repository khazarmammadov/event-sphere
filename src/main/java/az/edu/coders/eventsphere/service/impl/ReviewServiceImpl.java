package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.mapper.ReviewMapper;
import az.edu.coders.eventsphere.model.dto.request.CreatedReviewRequest;
import az.edu.coders.eventsphere.repository.ReviewRepository;
import az.edu.coders.eventsphere.security.properties.LoggedInUserDetails;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.ReviewService;
import az.edu.coders.eventsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final EventService eventService;
    @Override
    public void addReview(CreatedReviewRequest reviewRequest, Long eventId) {

        Review review = reviewMapper.toEntity(reviewRequest);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoggedInUserDetails principal = (LoggedInUserDetails) authentication.getPrincipal();
        User user = userService.getById(principal.getId());
        review.setUser(user);
        Event event = eventService.findEventById(eventId);
        review.setEvent(event);

        reviewRepository.save(review);
    }

    @Override
    public Page<Review> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
