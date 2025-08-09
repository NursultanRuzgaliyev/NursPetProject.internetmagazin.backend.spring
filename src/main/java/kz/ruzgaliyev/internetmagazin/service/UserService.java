package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.requestDto.UserRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(Long id,UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUser();
    void deleteUser(Long id);
}
