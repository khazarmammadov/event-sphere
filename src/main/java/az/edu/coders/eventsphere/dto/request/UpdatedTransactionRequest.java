package az.edu.coders.eventsphere.dto.request;

import az.edu.coders.eventsphere.enumurated.PaymentStatus;
import lombok.Data;

@Data
public class UpdatedTransactionRequest {

    private PaymentStatus status;
}
