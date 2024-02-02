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
    private final EventService eventService;

    public void createTransaction(CreatedTransactionRequest request) {

        Event event = eventService.getEntityById(request.getEventId());

        if (!(request.getQuantity() > event.getRestOfPlace())) {
            Customer customer = customerService.getEntityById(request.getCustomerId());
            Transaction transaction = transactionMapper.toEntity(request);
            double totalPrice = event.getTicketPrice() * request.getQuantity();
            transaction.setTotalPrice(totalPrice);
            transaction.setEvent(event);
            transaction.setCustomer(customer);
            transactionRepository.save(transaction);
            int updatedPlaces = event.getRestOfPlace() - request.getQuantity();
            eventService.updateRestOfPlace(event.getId(), updatedPlaces);
        } else {
            throw new RuntimeException("Rest of place is: " + event.getRestOfPlace());
        }
    }

    public void updateTransaction(Long id, UpdatedTransactionRequest request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Not Found by given id: " + id));
        transactionMapper.updateEntity(transaction, request);
        transactionRepository.save(transaction);
    }


}
