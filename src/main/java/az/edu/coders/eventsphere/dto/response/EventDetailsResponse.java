package az.edu.coders.eventsphere.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDetailsResponse {
    private String name;
    private String description;
    private String location;
    private double ticketPrice;
    private String eventDateAndTime;
    private String ticketSellingPeriod;
    private String picturePath;
}
