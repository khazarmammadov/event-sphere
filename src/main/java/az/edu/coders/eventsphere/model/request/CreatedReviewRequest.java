package az.edu.coders.eventsphere.model.request;

import lombok.Data;

@Data
public class CreatedReviewRequest {

    private int star;
    private String description;
}
