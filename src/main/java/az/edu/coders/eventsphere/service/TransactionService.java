package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction saveTransaction(CreatedTransactionRequest request) {
        Transaction transaction = new Transaction();

        return transactionRepository.save(transaction);
    }

}
