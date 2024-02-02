package az.edu.coders.eventsphere.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "created_by", unique = true)
    private User user;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String phone_number;
    private String address;
    private String picturePath;
}
