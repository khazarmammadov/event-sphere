package az.edu.coders.eventsphere.controllers;

import az.edu.coders.eventsphere.dto.JwtAuthenticationResponse;
import az.edu.coders.eventsphere.dto.SignInRequest;
import az.edu.coders.eventsphere.dto.SignUpRequest;
import az.edu.coders.eventsphere.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }
//
//    @GetMapping("/user")
//    public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal) {
//        return principal.getAttributes();
//    }
}