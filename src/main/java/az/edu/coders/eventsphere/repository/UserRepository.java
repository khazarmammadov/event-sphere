package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
