package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.model.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody CreatedUserRequest request) {
        return userService.saveUser(request);
    }


}
