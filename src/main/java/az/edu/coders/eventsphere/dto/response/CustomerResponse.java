package az.edu.coders.eventsphere.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
public class CustomerResponse {

    private Long customerId;
    private String profilePicturePath;
    private String fullName;
    private String email;
    private String registerDate;

}
