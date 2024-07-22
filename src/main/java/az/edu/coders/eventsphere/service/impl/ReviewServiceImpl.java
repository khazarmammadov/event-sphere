package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.mapper.ReviewMapper;
import az.edu.coders.eventsphere.model.request.CreatedReviewRequest;
import az.edu.coders.eventsphere.model.response.ReviewResponse;
import az.edu.coders.eventsphere.repository.ReviewRepository;
import az.edu.coders.eventsphere.security.properties.LoggedInUserDetails;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.ReviewService;
import az.edu.coders.eventsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Page<ReviewResponse> getAllReviews(Pageable pageable) {
        Page<Review> all = reviewRepository.findAll(pageable);

        List<ReviewResponse> collect = all.stream()
                .map(reviewMapper::toReviewResponse)
                .toList();

        return new PageImpl<>(collect, pageable, all.getTotalElements());

    }


}
