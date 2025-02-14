package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(int id, UserDto userDto);
    boolean deleteUser(int id);
}
