package az.edu.coders.eventsphere.dto.request;

import lombok.Data;

@Data
public class UpdatedEventRequest {

    private String name;
    private String description;
    private String picturePath;
    private String location;

}
