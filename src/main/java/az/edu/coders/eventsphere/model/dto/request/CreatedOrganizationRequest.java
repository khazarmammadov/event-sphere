package az.edu.coders.eventsphere.model.dto.request;

import lombok.Data;

@Data
public class CreatedOrganizationRequest {
    private String name;
    private String primaryContact;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
}
