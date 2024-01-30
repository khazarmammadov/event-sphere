package az.edu.coders.eventsphere.entity;

import az.edu.coders.eventsphere.enumurated.EventStatus;
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
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "created_by", unique = true)
    private User user;
    private String name;
    private String description;
    private String picturePath;
    private String location;
    private LocalDate eventDate;
    private LocalDateTime eventTime;
    private int restOfPlace;
    private double ticketPrice;
    private LocalDate ticketSellingStartDate;
    private LocalDate ticketSellingStopDate;
    private LocalDate createdAt;
    @Enumerated(EnumType.ORDINAL)
    private EventStatus status;

}
