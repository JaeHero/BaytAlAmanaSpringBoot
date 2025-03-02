package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import com.example.BaytAlAmana.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(int id, UserDto userDto);
    boolean deleteUser(int id);
    boolean assignUserToInvestment(int id, int investmentId);
    public boolean removeUserFromInvestment(int id, int investmentId);
}
