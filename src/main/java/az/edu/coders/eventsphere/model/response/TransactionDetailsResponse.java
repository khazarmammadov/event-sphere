package az.edu.coders.eventsphere.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDetailsResponse {

    private String customerName;
    private String email;
    private Long eventId;
    private Long quantity;
    private double totalPrice;
    private String eventName;
    private String description;
    private String location;
    private double ticketPrice;
    private String eventDateAndTime;
    private String ticketSellingPeriod;
}
