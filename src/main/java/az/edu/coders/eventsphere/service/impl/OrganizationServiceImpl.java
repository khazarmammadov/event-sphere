package az.edu.coders.eventsphere.service.impl;

import az.edu.coders.eventsphere.model.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Organization;
import az.edu.coders.eventsphere.mapper.OrganizationMapper;
import az.edu.coders.eventsphere.repository.OrganizationRepository;
import az.edu.coders.eventsphere.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    public Organization saveOrganization(CreatedOrganizationRequest request) {
        Organization organization = organizationMapper.toEntity(request);
        return organizationRepository.save(organization);
    }
}
