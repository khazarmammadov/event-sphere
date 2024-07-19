package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;

public interface UserService {
    User saveUser(CreatedUserRequest request);
    User getByMail(String mail);
    User getById(Long userId);
    boolean checkByMail(String mail);

}
