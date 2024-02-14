package az.edu.coders.eventsphere.dto.response;

import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerTransactionResponse {

    private String eventName;
    private LocalDate eventDate;
    private int quantity;
    private double total;
    private PaymentStatus status;
}
