package az.edu.coders.eventsphere.dto.request;

import lombok.Data;

@Data
public class CreatedTransactionRequest {

    private Long customerId;

    private Long eventId;

    private int quantity;



}
