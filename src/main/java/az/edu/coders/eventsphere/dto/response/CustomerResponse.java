package az.edu.coders.eventsphere.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class CustomerResponse {

    private Long customerId;
    private String profilePicturePath;
    private String fullName;
    private String email;
    private String registerDate;

}
