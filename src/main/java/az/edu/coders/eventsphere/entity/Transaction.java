package az.edu.coders.eventsphere.entity;

import az.edu.coders.eventsphere.enumurated.EventStatus;
import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    private int quantity;
    private double totalPrice;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
    private LocalDateTime transactionDate;


}
