package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.entity.Transaction;

import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactionByDate() {
        return transactionService.getTransactionsByDate();
    }

    @GetMapping("/ticket-sold")
    public Integer getSoldTicketCurrentMonth() {
        return transactionService.getCurrentMonthSalesWithStatus1();
    }
    @GetMapping("/sold-percentage")
    public double getMonthlyTicketSalesDifferenceWithPercentage() {
        return transactionService.getMonthlyTicketSalesDifferenceWithPercentage();
    }

    @GetMapping("/ticket-refund")
    public Integer getRefundTicketCurrentMonth() {
        return transactionService.getCurrentMonthRefundWithStatus2();
    }
    @GetMapping("/refund-percentage")
    public double getMonthlyTicketRefundDifferenceWithPercentage() {
        return transactionService.getMonthlyTicketRefundDifferenceWithPercentage();
    }

    @GetMapping("/revenue")
    public double getMonthlyRevenue() {
        return transactionService.getMonthlyRevenue();
    }

    @GetMapping("/revenue-percentage")
    public double getMonthlyRevenueDifferenceWithPercentage() {
        return transactionService.getMonthlyRevenueDifferenceWithPercentage();
    }




}
