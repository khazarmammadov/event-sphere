package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.model.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Organization;
import az.edu.coders.eventsphere.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Organization saveOrganization(@RequestBody CreatedOrganizationRequest request) {
        return organizationService.saveOrganization(request);
    }
}
