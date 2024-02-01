package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.mapper.CustomerMapper;
import az.edu.coders.eventsphere.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public void saveCustomer(CreatedCustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);

        customerRepository.save(customer);
    }
}
