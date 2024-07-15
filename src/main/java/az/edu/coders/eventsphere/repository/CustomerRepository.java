package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> getCustomersByUser(User user);
}
