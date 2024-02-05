package az.edu.coders.eventsphere.dto.response;

import az.edu.coders.eventsphere.entity.BillingDetails;
import az.edu.coders.eventsphere.entity.Customer;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDetailsResponse {

    private Long id;

    private String customerPicture;
    private String customerName;

    private String eventName;

    private PaymentStatus status;

    private int quantity;
    private double price;
    private double totalPrice;



}
