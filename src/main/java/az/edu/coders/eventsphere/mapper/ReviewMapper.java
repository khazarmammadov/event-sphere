package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.entity.Review;
import az.edu.coders.eventsphere.model.request.CreatedReviewRequest;
import az.edu.coders.eventsphere.model.response.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Review toEntity(CreatedReviewRequest reviewRequest);

    @Mapping(target = "eventName" , source = "event.name")
    @Mapping(target = "customerName" , source = "user.mail")
    ReviewResponse toReviewResponse(Review review);
}
