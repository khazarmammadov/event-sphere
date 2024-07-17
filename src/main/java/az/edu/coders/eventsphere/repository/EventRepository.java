package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.enumurated.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByStatus(EventStatus status);

    Optional<Event> findEventById(Long eventId);

   // @Query("SELECT e FROM Event e WHERE e.eventDate < :date AND e.status = :status")
    List<Event> findByEventDateBeforeAndStatus(LocalDate date, EventStatus status);

}
