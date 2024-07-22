package az.edu.coders.eventsphere.model.response;

import az.edu.coders.eventsphere.entity.Customer;
import lombok.Data;

@Data
public class ReviewResponse {
    private String eventName;
    private int star;
    private String CustomerName;
    private String description;
}
