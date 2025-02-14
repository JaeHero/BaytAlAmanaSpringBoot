package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.UserDto;
import com.example.BaytAlAmana.entity.UserEntity;
import com.example.BaytAlAmana.mapper.UserMapper;
import com.example.BaytAlAmana.repo.UserRepository;
import com.example.BaytAlAmana.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.INSTANCE.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(int id) {
        return UserMapper.INSTANCE.toUserDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserMapper.INSTANCE.toUserEntity(userDto));
        return UserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        UserEntity userEntityToUpdate = UserMapper.INSTANCE.toUserEntity(userDto);
        return UserMapper.INSTANCE.toUserDto(userRepository.save(userEntityToUpdate));
    }

    @Override
    public boolean deleteUser(int id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
