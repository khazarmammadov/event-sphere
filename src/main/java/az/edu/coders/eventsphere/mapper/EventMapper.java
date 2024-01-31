package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedEventRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.dto.response.EventDetailsResponse;
import az.edu.coders.eventsphere.entity.Event;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {

    Event toEntity(CreatedEventRequest request);

    void updateEntity(@MappingTarget Event entity, UpdatedEventRequest request);

    EventDetailsResponse toEventDetailsResponse(Event entity);

    @AfterMapping
    default void afterMap(EventDetailsResponse result, Event entity) {
        String sellingPeriod = entity.getTicketSellingStartDate().toString() +
                " --> " + entity.getTicketSellingStopDate().toString();
        result.setTicketSellingPeriod(sellingPeriod);
    }

}
