package az.edu.coders.eventsphere.dto.request;

import az.edu.coders.eventsphere.entity.Organization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CreatedUserRequest {
    private String mail;
    private String password;

}
