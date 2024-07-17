package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.model.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Event;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionService {
    void createTransaction(Event event, CreatedTransactionRequest request);

    List<Transaction> getTransactionsByDate();

    Integer getCurrentMonthSalesWithStatus1();

    Integer getCountOfSoldTicketsFromPreviousMonth();
    double getMonthlyTicketSalesDifferenceWithPercentage();

    Integer getCurrentMonthRefundWithStatus2();

    double getMonthlyTicketRefundDifferenceWithPercentage();

    Integer getCountOfRefundTicketsFromPreviousMonth();

    Integer getMonthlyRevenue();

    double getMonthlyRevenueDifferenceWithPercentage();
}
