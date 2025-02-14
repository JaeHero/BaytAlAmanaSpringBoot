package com.example.BaytAlAmana.mapper;

import com.example.BaytAlAmana.dto.UserDto;
import com.example.BaytAlAmana.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(UserEntity userEntity);
    UserEntity toUserEntity(UserDto userDto);
    List<UserDto> toUserDtoList(List<UserEntity> userEntityList);
}
