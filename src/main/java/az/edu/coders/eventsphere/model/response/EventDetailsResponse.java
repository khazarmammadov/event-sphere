package az.edu.coders.eventsphere.model.response;

import lombok.Builder;
import lombok.Data;

@Data
public class EventDetailsResponse {
    private String name;
    private String description;
    private String location;
    private double ticketPrice;
    private String eventDateAndTime;
    private String ticketSellingPeriod;
    private String picturePath;
}
