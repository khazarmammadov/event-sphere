package az.edu.coders.eventsphere.model.request;

import az.edu.coders.eventsphere.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatedCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String phoneNumber;
    private String address;

    
}
