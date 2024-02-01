package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {

    Transaction toEntity(CreatedTransactionRequest request);
}
