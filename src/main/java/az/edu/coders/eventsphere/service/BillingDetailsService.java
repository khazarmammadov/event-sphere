package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.entity.BillingDetails;
import az.edu.coders.eventsphere.model.request.CreatedBillingDetailsRequest;

public interface BillingDetailsService {
    BillingDetails createDetails();
}
