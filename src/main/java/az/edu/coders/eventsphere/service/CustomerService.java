package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.model.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface CustomerService {
    void saveCustomer(CreatedCustomerRequest request, MultipartFile file);
    Customer getEntityById(Long customerId);
    Customer getCustomersByUser(User user);
}
