package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
