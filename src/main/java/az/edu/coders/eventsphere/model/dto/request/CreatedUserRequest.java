package az.edu.coders.eventsphere.model.dto.request;

import az.edu.coders.eventsphere.entity.Organization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreatedUserRequest {
    private String name;
    private String surname;
    private String mail;
    private String password;
    private LocalDateTime createdAt;

}
