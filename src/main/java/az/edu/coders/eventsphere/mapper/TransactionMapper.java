package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedTransactionRequest;
import az.edu.coders.eventsphere.dto.response.CustomerTransactionResponse;
import az.edu.coders.eventsphere.dto.response.TransactionDetailsResponse;
import az.edu.coders.eventsphere.entity.Transaction;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    @Mapping(target = "transactionDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(az.edu.coders.eventsphere.enumurated.PaymentStatus.PENDING)")
    Transaction toEntity(CreatedTransactionRequest request);


    void updateEntity(@MappingTarget Transaction transaction, UpdatedTransactionRequest request);

    TransactionDetailsResponse toTransactionDetailsResponse(Transaction entity);

    @AfterMapping
    default void afterMapToTransactionDetailsResponse(@MappingTarget TransactionDetailsResponse result,
                                                                                                Transaction entity) {

        result.setCustomerPicture(entity.getCustomer().getPicturePath());
        result.setCustomerName(entity.getCustomer().getFirstName() +  " " + entity.getCustomer().getLastName());
        result.setEventName(entity.getEvent().getName());
        result.setPrice(entity.getEvent().getTicketPrice());

    }

    CustomerTransactionResponse toCustomerTransactionResponse(Transaction transaction);

    @AfterMapping
    default void afterMapToCustomerTransactionResponse(@MappingTarget CustomerTransactionResponse result,
                                                                        Transaction entity) {

        result.setEventName(entity.getEvent().getName());
        result.setEventDate(entity.getEvent().getEventDate());
        result.setTotal(entity.getTotalPrice());
    }
}
