package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.model.request.CreatedCustomerRequest;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.mapper.CustomerMapper;
import az.edu.coders.eventsphere.repository.CustomerRepository;
import az.edu.coders.eventsphere.security.properties.LoggedInUserDetails;
import az.edu.coders.eventsphere.service.CustomerService;
import az.edu.coders.eventsphere.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final MinioService minioService;

    private static final String bucketName = "customer-pictures";

    @Override
    public void saveCustomer(CreatedCustomerRequest request, MultipartFile file) {
        Customer customer = customerMapper.toEntity(request);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoggedInUserDetails principal = (LoggedInUserDetails) authentication.getPrincipal();
        User user = new User();
        user.setId(principal.getId());
        customer.setUser(user);
        customerRepository.save(customer);

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + "." + extension;

        try {
            minioService.putObject(file.getInputStream(), bucketName, fileName, "JPEG");
            customer.setPicturePath(bucketName + "/" + fileName);
            customerRepository.save(customer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getEntityById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found given by id: " + customerId));

    }

    @Override
    public Customer getCustomersByUser(User user) {
        return customerRepository.getCustomersByUser(user).orElseThrow(
                () -> new RuntimeException("Customer not found given by id: " + user));
    }
}

//    @Override
//    public Customer getEntityById(Long customerId) {
//        return customerRepository.findById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found given by id: " + customerId));
//    }

