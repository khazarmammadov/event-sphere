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

import java.util.List;

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

    @Override
    public List<Transaction> getTransactionsByDate() {
        return transactionRepository.findTop5ByOrderByDateDesc();
    }

    @Override
    public Integer getCurrentMonthSalesWithStatus1() {
        return transactionRepository.getCurrentMonthSalesWithStatus1();
    }

    @Override
    public Integer getCountOfSoldTicketsFromPreviousMonth() {
        return transactionRepository.getCountOfSoldTicketsFromPreviousMonth();
    }

    @Override
    public double getMonthlyTicketSalesDifferenceWithPercentage() {
        Integer currentMonthSales = getCurrentMonthSalesWithStatus1();

        Integer previousMonthSales = getCountOfSoldTicketsFromPreviousMonth();

        if (previousMonthSales == null || previousMonthSales == 0) {
            return currentMonthSales != null ? 100.0 : 0.0;
        }

        double difference = currentMonthSales - previousMonthSales;
        return (difference / previousMonthSales) * 100;
    }

    @Override
    public Integer getCurrentMonthRefundWithStatus2() {
        return transactionRepository.getCurrentMonthRefundWithStatus2();
    }

    @Override
    public Integer getCountOfRefundTicketsFromPreviousMonth() {
        return transactionRepository.getCountOfRefundTicketsFromPreviousMonth();
    }


    @Override
    public double getMonthlyTicketRefundDifferenceWithPercentage() {
        Integer currentMonthRefund = getCurrentMonthRefundWithStatus2();

        Integer previousMonthRefund = getCountOfRefundTicketsFromPreviousMonth();

        if (previousMonthRefund == null || previousMonthRefund == 0) {
            return currentMonthRefund != null ? 100.0 : 0.0;
        }

        double difference = currentMonthRefund - previousMonthRefund;
        return (difference / previousMonthRefund) * 100;
    }

    @Override
    public Integer getMonthlyRevenue() {
        return transactionRepository.getMonthlyRevenue();
    }

    @Override
    public double getMonthlyRevenueDifferenceWithPercentage() {
        Integer currentMonthRevenue = getMonthlyRevenue();

        Integer previousMonthRevenue = getPreviousMonthlyRevenue();

        if (previousMonthRevenue == null || currentMonthRevenue == 0) {
            return currentMonthRevenue != null ? 100.0 : 0.0;
        }

        double difference = currentMonthRevenue - previousMonthRevenue;
        return (difference / previousMonthRevenue) * 100;
    }

    private Integer getPreviousMonthlyRevenue() {
        return transactionRepository.getPreviousMonthlyRevenue();
    }

}
