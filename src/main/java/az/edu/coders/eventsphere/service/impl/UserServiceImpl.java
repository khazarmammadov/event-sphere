package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.model.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.mapper.UserMapper;
import az.edu.coders.eventsphere.repository.UserRepository;
import az.edu.coders.eventsphere.security.properties.LoggedInUserDetails;
import az.edu.coders.eventsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User saveUser(CreatedUserRequest request) {
        User user = userMapper.toEntity(request);
        return userRepository.save(user);
    }

    @Override
    public User getByMail(String mail) {
        return userRepository.findByMail(mail)
                .orElseThrow( () -> new RuntimeException("Not found mail")
                );
    }

    @Override
    public boolean checkByMail(String mail) {
        return userRepository.findByMail(mail).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByMail(username);

        System.out.println("kecir");
        return new LoggedInUserDetails(
                user.getId(), user.getMail(), user.getPassword(), new ArrayList<>()
        );
    }
}
