package az.edu.coders.eventsphere.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventResponse {

    private Long id;
    private String name;
    private String ticketSellingPeriod;
    private String quantity;
    private double price;

}
