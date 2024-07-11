package az.edu.coders.eventsphere.security.service.impl;


import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.model.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.security.dto.RefreshTokenDto;
import az.edu.coders.eventsphere.security.manager.AccessTokenManager;
import az.edu.coders.eventsphere.security.manager.RefreshTokenManager;
import az.edu.coders.eventsphere.security.payload.LoginPayload;
import az.edu.coders.eventsphere.security.payload.RefreshTokenPayload;
import az.edu.coders.eventsphere.security.payload.SignUpPayload;
import az.edu.coders.eventsphere.security.response.LoginResponse;
import az.edu.coders.eventsphere.security.service.AuthBusinessService;
import az.edu.coders.eventsphere.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthBusinessServiceImpl implements AuthBusinessService {

    final static String BRANCH_NAME_DEFAULT_PATTERN = "%s Default Branch";

    final AuthenticationManager authenticationManager;
    final AccessTokenManager accessTokenManager;
    final RefreshTokenManager refreshTokenManager;
    final UserService userService;
    final UserDetailsService userDetailsService;
    final BCryptPasswordEncoder passwordEncoder;


    @Override
    public LoginResponse login(LoginPayload payload) {

        authenticate(payload);

        return prepareLoginResponse(payload.getMail(), payload.isRememberMe());
    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {
        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken()),
                payload.isRememberMe()
        );
    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public void signUp(SignUpPayload payload) {

        if (userService.checkByMail(payload.getMail())) {
            throw new RuntimeException("User Exist...");
        }


        CreatedUserRequest request = CreatedUserRequest.builder()
                .name(payload.getName())
                .surname(payload.getSurname())
                .mail(payload.getMail())
                .password(passwordEncoder.encode(payload.getPassword()))
                .build();
        userService.saveUser(request);


    }


    @Override
    public void setAuthentication(String mail) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(mail);

        SecurityContextHolder.getContext().setAuthentication(
                UsernamePasswordAuthenticationToken.authenticated(userDetails, "", userDetails.getAuthorities())
        );
    }

    private void authenticate(LoginPayload request) {
        try {
            authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken.unauthenticated(request.getMail(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new RuntimeException("Wrong Credentials: "  + e.getMessage());
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getByMail(email);

        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();
    }


}