package az.edu.coders.eventsphere.security.controller;


import az.edu.coders.eventsphere.security.base.cs.BaseResponse;
import az.edu.coders.eventsphere.security.payload.LoginPayload;
import az.edu.coders.eventsphere.security.payload.RefreshTokenPayload;
import az.edu.coders.eventsphere.security.payload.SignUpPayload;
import az.edu.coders.eventsphere.security.response.LoginResponse;
import az.edu.coders.eventsphere.security.service.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {
        System.out.println("PAYLOAD: " + payload);
        return BaseResponse.success(authBusinessService.login(payload));
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshTokenPayload payload) {
        return BaseResponse.success(authBusinessService.refresh(payload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout() {
        authBusinessService.logout();
        return BaseResponse.success();
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpPayload payload) {
         authBusinessService.signUp(payload);
    }



}