package az.edu.coders.eventsphere.dto.response;

import lombok.Data;

@Data
public class TransactionDetailsResponse {

    private String customerName;
    private String email;
    private Long eventId;
    private int quantity;
    private double totalPrice;
    private String eventName;
    private String description;
    private String location;
    private double ticketPrice;
    private String eventDateAndTime;
    private String ticketSellingPeriod;
}
