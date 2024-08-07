package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.model.request.CreatedBillingDetailsRequest;
import az.edu.coders.eventsphere.model.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.model.response.TransactionDetailsResponseForDashboard;

import java.util.List;

public interface TransactionService {
    void createTransaction(Event event, CreatedTransactionRequest request);
    List<TransactionDetailsResponseForDashboard> getTransactionsByDate();
    Integer getCurrentMonthSalesWithStatus1();
    Integer getCountOfSoldTicketsFromPreviousMonth();
    double getMonthlyTicketSalesDifferenceWithPercentage();
    Integer getCurrentMonthRefundWithStatus2();
    double getMonthlyTicketRefundDifferenceWithPercentage();
    Integer getCountOfRefundTicketsFromPreviousMonth();
    Integer getMonthlyRevenue();
    double getMonthlyRevenueDifferenceWithPercentage();

}
