package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.model.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void saveCustomer(@RequestPart("data") CreatedCustomerRequest request,
                             @RequestPart("file") MultipartFile file) {
        customerService.saveCustomer(request, file);
    }
}
