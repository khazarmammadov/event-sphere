package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT t FROM Transaction t ORDER BY t.transactionDate DESC")
    List<Transaction> findTop5ByOrderByDateDesc();
}
