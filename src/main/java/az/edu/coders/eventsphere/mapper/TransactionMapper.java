package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    @Mapping(target = "transactionDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(az.edu.coders.eventsphere.enumurated.PaymentStatus.PENDING)")
    Transaction toEntity(CreatedTransactionRequest request);


}
