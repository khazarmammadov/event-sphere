package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.mapper.TransactionMapper;
import az.edu.coders.eventsphere.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final EventService eventService;

//    public Transaction createTransaction(CreatedTransactionRequest request) {
//        Transaction transaction = transactionMapper.toEntity(request);
//        transaction = transactionMapper.toEntity(eventService.getDetailsById(request.getEventId()))
//        return transactionRepository.save(transaction);
//    }

}
