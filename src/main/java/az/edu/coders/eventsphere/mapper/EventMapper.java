package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.model.request.CreatedEventRequest;
import az.edu.coders.eventsphere.model.request.UpdatedEventRequest;
import az.edu.coders.eventsphere.model.response.EventDetailsResponse;
import az.edu.coders.eventsphere.model.response.EventResponse;
import az.edu.coders.eventsphere.entity.Event;
import org.mapstruct.*;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "status", expression = "java(az.edu.coders.eventsphere.enumurated.EventStatus.ACTIVE)")
    Event toEntity(CreatedEventRequest request);

    void updateEntity(@MappingTarget Event entity, UpdatedEventRequest request);

    EventDetailsResponse toEventDetailsResponse(Event entity);

    @AfterMapping
    default void afterMap(@MappingTarget EventDetailsResponse result, Event entity) {
        String sellingPeriod = entity.getTicketSellingStartDate().toString() +
                " --> " + entity.getTicketSellingStopDate().toString();
        result.setTicketSellingPeriod(sellingPeriod);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = entity.getEventTime().format(formatter);

        result.setEventDateAndTime(formattedDateTime);


    }

    EventResponse toEventResponse(Event event);

    @AfterMapping
    default void afterMap2(@MappingTarget EventResponse result, Event event) {
        String sellingPeriod = event.getTicketSellingStartDate().toString() +
                " --> " + event.getTicketSellingStopDate().toString();
        result.setTicketSellingPeriod(sellingPeriod);



    }
}
