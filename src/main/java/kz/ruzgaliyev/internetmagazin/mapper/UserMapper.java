package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.Role;
import kz.ruzgaliyev.internetmagazin.entity.User;
import kz.ruzgaliyev.internetmagazin.requestDto.UserRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDto dto);

    @Mapping(source = "roles",target = "roles",qualifiedByName = "mapRolesToStrings")
    UserResponseDto toDto(User user);

    @Named("mapRolesToStrings")
    default Set<String> mapRolesToStrings(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
