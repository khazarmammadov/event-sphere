package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(CreatedUserRequest request) {
        User user = new User();

        return userRepository.save(user);
    }
}
