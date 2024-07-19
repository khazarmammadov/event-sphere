package az.edu.coders.eventsphere.service;

import az.edu.coders.eventsphere.model.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Organization;

public interface OrganizationService {
    Organization saveOrganization(CreatedOrganizationRequest request);
}
