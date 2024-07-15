package az.edu.coders.eventsphere.repository;


import az.edu.coders.eventsphere.entity.Review;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    @NotNull
    Page<Review> findAll(@NotNull Pageable pageable);
}
