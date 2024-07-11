package az.edu.coders.eventsphere.mapper;

import az.edu.coders.eventsphere.model.dto.request.CreatedUserRequest;
import az.edu.coders.eventsphere.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User toEntity(CreatedUserRequest request);
}
