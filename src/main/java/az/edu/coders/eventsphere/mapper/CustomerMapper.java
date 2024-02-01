package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer toEntity(CreatedCustomerRequest request);
}
