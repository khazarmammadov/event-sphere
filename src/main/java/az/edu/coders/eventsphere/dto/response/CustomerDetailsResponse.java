package az.edu.coders.eventsphere.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDetailsResponse {


    private Long id;
    private Long createdBy;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String phone_number;
    private String address;
    private String picturePath;
    private LocalDate registeredDate;
}
