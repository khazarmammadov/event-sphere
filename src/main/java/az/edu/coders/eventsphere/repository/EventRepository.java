package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> getEventByStatus(EventStatus status);

}
