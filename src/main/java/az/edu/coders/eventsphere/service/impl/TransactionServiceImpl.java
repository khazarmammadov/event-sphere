package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.mapper.TransactionMapper;
import az.edu.coders.eventsphere.repository.TransactionRepository;
import az.edu.coders.eventsphere.service.CustomerService;
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final CustomerService customerService;

    @Override
    public void createTransaction(Event event, CreatedTransactionRequest request) {
        Customer customer = customerService.getEntityById(request.getCustomerId());
        Transaction transaction = transactionMapper.toEntity(request);
        double totalPrice = event.getTicketPrice() * request.getQuantity();
        transaction.setTotalPrice(totalPrice);
        transaction.setEvent(event);
        transaction.setCustomer(customer);
        transactionRepository.save(transaction);

    }
}
