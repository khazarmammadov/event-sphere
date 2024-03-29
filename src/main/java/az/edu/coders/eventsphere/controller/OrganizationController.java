package az.edu.coders.eventsphere.controller;

import az.edu.coders.eventsphere.dto.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Event;
import az.edu.coders.eventsphere.entity.Organization;
import az.edu.coders.eventsphere.service.EventService;
import az.edu.coders.eventsphere.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Organization saveOrganization(@RequestBody CreatedOrganizationRequest request) {
        return organizationService.saveOrganization(request);
    }
}
