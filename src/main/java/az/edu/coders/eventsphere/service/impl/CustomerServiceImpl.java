package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.model.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.mapper.CustomerMapper;
import az.edu.coders.eventsphere.repository.CustomerRepository;
import az.edu.coders.eventsphere.security.properties.LoggedInUserDetails;
import az.edu.coders.eventsphere.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void saveCustomer(CreatedCustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        LoggedInUserDetails principal = (LoggedInUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        user.setId(principal.getId());
        customer.setUser(user);
        customerRepository.save(customer);
    }

    @Override
    public Customer getEntityById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found given by id: " + customerId));
    }
}
