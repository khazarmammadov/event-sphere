package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.dto.response.CustomerResponse;
import az.edu.coders.eventsphere.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void saveCustomer(@RequestBody CreatedCustomerRequest request) {
        customerService.saveCustomer(request);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
