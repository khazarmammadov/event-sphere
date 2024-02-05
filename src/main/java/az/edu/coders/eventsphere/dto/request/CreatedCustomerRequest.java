package az.edu.coders.eventsphere.dto.request;

import az.edu.coders.eventsphere.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreatedCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String phone_number;
    private String address;
    private String picturePath;
}
