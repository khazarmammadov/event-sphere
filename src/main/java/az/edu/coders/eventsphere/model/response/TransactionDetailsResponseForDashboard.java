package az.edu.coders.eventsphere.model.response;

import az.edu.coders.eventsphere.entity.Customer;
import lombok.Data;

@Data
public class TransactionDetailsResponseForDashboard {

    private Long id;
    private String customerName;
    private String eventName;
    private int quantity;
    private double totalPrice;

}
