package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getAllByCustomerId(Long customerId);
}
