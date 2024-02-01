package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void saveCustomer(@RequestParam CreatedCustomerRequest request) {
        customerService.saveCustomer(request);
    }
}
