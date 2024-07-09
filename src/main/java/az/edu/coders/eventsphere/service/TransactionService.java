package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Event;

public interface TransactionService {
    void createTransaction(Event event, CreatedTransactionRequest request);
}
