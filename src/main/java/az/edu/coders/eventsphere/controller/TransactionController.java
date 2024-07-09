package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

//    @PostMapping
//    public Transaction saveTransaction(@RequestBody CreatedTransactionRequest request) {
//        return transactionService.saveTransaction(request);
//    }

//    @PostMapping()
//    public void getDetailsById(@RequestBody CreatedTransactionRequest request) {
//        transactionService.createTransaction(request);
//    }
}
