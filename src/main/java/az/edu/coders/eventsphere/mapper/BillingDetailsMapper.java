package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.entity.BillingDetails;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.model.request.CreatedBillingDetailsRequest;
import az.edu.coders.eventsphere.model.request.CreatedEventRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BillingDetailsMapper {

    BillingDetails toEntity(CreatedBillingDetailsRequest billingDetailsRequest);
}
