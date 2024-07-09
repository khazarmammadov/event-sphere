package az.edu.coders.eventsphere.security.payload;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginPayload {

    String mail;
    String password;
    boolean rememberMe;
}