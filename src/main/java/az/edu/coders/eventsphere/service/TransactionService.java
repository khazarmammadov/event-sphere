package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import az.edu.coders.eventsphere.mapper.TransactionMapper;
import az.edu.coders.eventsphere.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final CustomerService customerService;

    public void createTransaction(Event event, CreatedTransactionRequest request) {
        Customer customer = customerService.getEntityById(request.getCustomerId());
        Transaction transaction = transactionMapper.toEntity(request);
        double totalPrice = event.getTicketPrice() * request.getQuantity();
        transaction.setTotalPrice(totalPrice);
        transaction.setEvent(event);
        transaction.setCustomer(customer);
        transactionRepository.save(transaction);
    }

    public void updateTransaction(Long id, UpdatedTransactionRequest request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        transactionMapper.updateEntity(transaction, request);
    }

}
