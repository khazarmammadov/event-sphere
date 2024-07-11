package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {
    void saveCustomer(CreatedCustomerRequest request, MultipartFile file);
    Customer getEntityById(Long customerId);
}
