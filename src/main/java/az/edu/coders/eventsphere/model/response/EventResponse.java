package az.edu.coders.eventsphere.model.response;

import lombok.Builder;
import lombok.Data;

@Data
public class EventResponse {

    private Long id;
    private String name;
    private String ticketSellingPeriod;
    private int restOfPlace;
    private double ticketPrice;

}
