package az.edu.coders.eventsphere.dto.response;

import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import lombok.Data;

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
