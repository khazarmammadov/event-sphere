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
}
