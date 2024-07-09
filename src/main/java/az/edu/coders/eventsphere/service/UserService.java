package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;

public interface UserService {
    User saveUser(CreatedUserRequest request);
    User getByMail(String mail);
    boolean checkByMail(String mail);
}
