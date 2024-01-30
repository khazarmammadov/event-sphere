package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.dto.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Organization;
import az.edu.coders.eventsphere.entity.User;
import az.edu.coders.eventsphere.repository.OrganizationRepository;
import az.edu.coders.eventsphere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public Organization saveOrganization(CreatedOrganizationRequest request) {
        Organization organization = new Organization();

        return organizationRepository.save(organization);
    }
}
