package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedTransactionRequest;
import az.edu.coders.eventsphere.dto.request.UpdatedTransactionRequest;
import az.edu.coders.eventsphere.dto.response.TransactionDetailsResponse;
import az.edu.coders.eventsphere.entity.Transaction;
import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Long id, @RequestBody UpdatedTransactionRequest request) {
        transactionService.updateTransaction(id, request);
    }

    @PutMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id, @RequestBody UpdatedTransactionRequest request) {
        transactionService.deleteTransaction(id, request);
    }

    @GetMapping
    public List<TransactionDetailsResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
