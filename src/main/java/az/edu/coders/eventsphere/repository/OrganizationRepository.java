package az.edu.coders.eventsphere.repository;

import az.edu.coders.eventsphere.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
