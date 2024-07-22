package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.model.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.model.response.EventResponse;
import az.edu.coders.eventsphere.model.response.TransactionDetailsResponseForDashboard;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    @Mapping(target = "transactionDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(az.edu.coders.eventsphere.enumurated.PaymentStatus.PAID)")
    Transaction toEntity(CreatedTransactionRequest request);



    @Mapping(target = "customerName", source = "transaction.customer", qualifiedByName = "customerName")
    @Mapping(target = "eventName", source = "event.name")
    TransactionDetailsResponseForDashboard toTransactionResponse(Transaction transaction);

    @Named("customerName")
    static String customerName(Customer customer) {
        return customer.getFirstName() + " " + customer.getLastName();
    }

}
