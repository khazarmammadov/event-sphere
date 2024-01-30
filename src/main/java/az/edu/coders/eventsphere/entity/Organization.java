package az.edu.coders.eventsphere.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String primaryContact;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private LocalDate createdAt;
}
