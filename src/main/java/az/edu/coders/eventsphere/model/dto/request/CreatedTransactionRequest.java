package az.edu.coders.eventsphere.model.dto.request;

import az.edu.coders.eventsphere.entity.BillingDetails;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedTransactionRequest {

    private Long customerId;

    private Long eventId;

    private Long quantity;



}
