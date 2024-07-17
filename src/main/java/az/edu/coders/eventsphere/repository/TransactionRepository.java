package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT t FROM Transaction t ORDER BY t.transactionDate DESC")
    List<Transaction> findTop5ByOrderByDateDesc();


    @Query(value = "SELECT SUM(t.quantity) FROM transaction t WHERE t.status = 1 " +
            "AND t.transaction_date >= date_trunc('month', current_date) " +
            "AND t.transaction_date < date_trunc('month', current_date) + INTERVAL '1 month'", nativeQuery = true)
    Integer getCurrentMonthSalesWithStatus1();

    @Query(value = "SELECT sum(t.quantity) FROM transaction t " +
            "WHERE t.status = 2 and t.transaction_date >= date_trunc('month', current_date) - INTERVAL '1 month' " +
            "AND t.transaction_date < date_trunc('month', current_date)",
            nativeQuery = true)
    Integer getCountOfSoldTicketsFromPreviousMonth();

    @Query(value = "SELECT SUM(t.quantity) FROM transaction t WHERE t.status = 2 " +
            "AND t.transaction_date >= date_trunc('month', current_date) " +
            "AND t.transaction_date < date_trunc('month', current_date) + INTERVAL '1 month'", nativeQuery = true)
    Integer getCurrentMonthRefundWithStatus2();

    @Query(value = "SELECT sum(t.quantity) FROM transaction t " +
            "WHERE t.status = 2 and t.transaction_date >= date_trunc('month', current_date) - INTERVAL '1 month' " +
            "AND t.transaction_date < date_trunc('month', current_date)",
            nativeQuery = true)
    Integer getCountOfRefundTicketsFromPreviousMonth();

    @Query(value = "SELECT sum(t.total_price) FROM transaction t " +
            "WHERE t.status = 1 and t.transaction_date >= date_trunc('month', current_date) - INTERVAL '1 month' " +
            "AND t.transaction_date < date_trunc('month', current_date)",
            nativeQuery = true)
    Integer getPreviousMonthlyRevenue();

    @Query(value = "SELECT SUM(t.total_price) FROM transaction t WHERE t.status = 1 " +
            "AND t.transaction_date >= date_trunc('month', current_date) " +
            "AND t.transaction_date < date_trunc('month', current_date) + INTERVAL '1 month'", nativeQuery = true)
    Integer getMonthlyRevenue();
}
