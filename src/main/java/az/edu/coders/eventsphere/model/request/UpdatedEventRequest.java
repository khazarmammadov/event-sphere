package az.edu.coders.eventsphere.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdatedEventRequest {

    private String name;
    private String description;
    private String picturePath;
    private String location;
    private LocalDate eventDate;
    private LocalDateTime eventTime;
    private int restOfPlace;
    private double ticketPrice;
    private LocalDate ticketSellingStartDate;
    private LocalDate ticketSellingStopDate;


}
