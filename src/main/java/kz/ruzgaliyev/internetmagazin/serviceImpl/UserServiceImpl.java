package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.requestDto.UserRequestDto;
import kz.ruzgaliyev.internetmagazin.responseDto.UserResponseDto;
import kz.ruzgaliyev.internetmagazin.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        return List.of();
    }

    @Override
    public void deleteUser(Long id) {

    }
}
