package az.edu.coders.eventsphere.security.service;


import az.edu.coders.eventsphere.security.payload.LoginPayload;
import az.edu.coders.eventsphere.security.payload.RefreshTokenPayload;
import az.edu.coders.eventsphere.security.payload.SignUpPayload;
import az.edu.coders.eventsphere.security.response.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    void signUp(SignUpPayload payload);

    void setAuthentication(String email);

}