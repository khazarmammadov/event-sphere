package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public Transaction saveTransaction(@RequestBody CreatedTransactionRequest request) {
        return transactionService.saveTransaction(request);
    }
}
