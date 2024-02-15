package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.dto.request.UpdateCustomerRequest;
import az.edu.coders.eventsphere.dto.response.CustomerDetailsResponse;
import az.edu.coders.eventsphere.dto.response.CustomerResponse;
import az.edu.coders.eventsphere.dto.response.CustomerTransactionResponse;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.mapper.CustomerMapper;
import az.edu.coders.eventsphere.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public void saveCustomer(CreatedCustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);

        customerRepository.save(customer);
    }

    public Customer getEntityById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found given by id: " + customerId));
    }

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return customerList.stream()
                .map(customerMapper::toCustomerResponse).collect(Collectors.toList());


    }

    public CustomerDetailsResponse getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found given by id: " + customerId));

        return customerMapper.toCustomerDetailsResponse(customer);
    }

    public void editCustomer(Long id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found given by id: " + id));
        customerMapper.toUpdateCustomerRequest(request, customer);
        customerRepository.save(customer);
    }
}
