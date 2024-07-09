package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.model.dto.request.CreatedOrganizationRequest;
import az.edu.coders.eventsphere.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationMapper {
    Organization toEntity(CreatedOrganizationRequest request);
}
