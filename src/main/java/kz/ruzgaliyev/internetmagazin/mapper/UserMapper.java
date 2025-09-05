package kz.ruzgaliyev.internetmagazin.mapper;

import kz.ruzgaliyev.internetmagazin.entity.User;
import kz.ruzgaliyev.internetmagazin.requestDto.UserCreateDto;
import kz.ruzgaliyev.internetmagazin.responseDto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDto dto);

    UserResponseDto toDto(User entity);
}

