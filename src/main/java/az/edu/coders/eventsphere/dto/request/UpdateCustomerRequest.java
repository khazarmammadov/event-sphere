package az.edu.coders.eventsphere.dto.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String phone_number;
    private String address;
    private String picturePath;
}
