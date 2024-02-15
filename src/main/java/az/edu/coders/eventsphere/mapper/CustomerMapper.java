package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.dto.request.UpdateCustomerRequest;
import az.edu.coders.eventsphere.dto.response.CustomerDetailsResponse;
import az.edu.coders.eventsphere.dto.response.CustomerResponse;
import az.edu.coders.eventsphere.entity.Customer;
import org.mapstruct.*;

import java.time.LocalDate;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target = "registeredDate", expression = "java(java.time.LocalDate.now())")
    Customer toEntity(CreatedCustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);

    @AfterMapping
    default void afterMap(@MappingTarget CustomerResponse result, Customer entity) {

        result.setCustomerId(entity.getId());
        result.setProfilePicturePath(entity.getPicturePath());
        result.setFullName(entity.getFirstName() + " " + entity.getLastName());
        result.setRegisterDate(LocalDate.now());

    }

    CustomerDetailsResponse toCustomerDetailsResponse(Customer customer);

    void toUpdateCustomerRequest(UpdateCustomerRequest request, @MappingTarget Customer entity);
}
