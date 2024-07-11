package az.edu.coders.eventsphere.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id" , unique = true)
    private Organization organization;
    private LocalDateTime createdAt;
    private int State;
}
