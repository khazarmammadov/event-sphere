package az.edu.coders.eventsphere.dto.response;

import lombok.Data;

@Data
public class EventDetailsResponse {
    private String name;
    private String description;
    private String picturePath;
    private String location;
    private String ticketSellingPeriod;
    private double ticketPrice;
}
