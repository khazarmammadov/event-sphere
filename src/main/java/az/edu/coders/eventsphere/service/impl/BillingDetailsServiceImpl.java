package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.entity.BillingDetails;
import az.edu.coders.eventsphere.mapper.BillingDetailsMapper;
import az.edu.coders.eventsphere.model.request.CreatedBillingDetailsRequest;
import az.edu.coders.eventsphere.repository.BillingDetailsRepository;
import az.edu.coders.eventsphere.service.BillingDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillingDetailsServiceImpl implements BillingDetailsService {

    private final BillingDetailsMapper billingDetailsMapper;
    private final BillingDetailsRepository billingDetailsRepository;
    @Override
    public BillingDetails createDetails() {

        return billingDetailsRepository.save(new BillingDetails());
    }
}
