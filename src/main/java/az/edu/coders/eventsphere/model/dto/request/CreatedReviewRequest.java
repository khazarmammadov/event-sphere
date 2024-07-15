package az.edu.coders.eventsphere.model.dto.request;

import lombok.Data;

@Data
public class CreatedReviewRequest {

    private int star;
    private String description;
}
