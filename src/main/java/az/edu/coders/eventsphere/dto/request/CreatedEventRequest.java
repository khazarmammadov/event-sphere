package az.edu.coders.eventsphere.dto.request;

import az.edu.coders.eventsphere.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreatedEventRequest {

    private Long userId;
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
