package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.dto.response.CustomerTransactionResponse;
import az.edu.coders.eventsphere.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
