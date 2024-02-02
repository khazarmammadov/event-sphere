package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedTransactionRequest;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Long id, @RequestBody UpdatedTransactionRequest request) {
        transactionService.updateTransaction(id, request);
    }
}
