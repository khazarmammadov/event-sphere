package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;

public interface CustomerService {
    void saveCustomer(CreatedCustomerRequest request);
    Customer getEntityById(Long customerId);
}
