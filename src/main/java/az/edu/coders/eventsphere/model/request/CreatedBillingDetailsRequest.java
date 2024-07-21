package az.edu.coders.eventsphere.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatedBillingDetailsRequest {

    private Long id;
    private Long userId;
    private boolean byCard;
    private int cardNumber;
    private String email;
    private String phoneNumber;
    private String address;
}
