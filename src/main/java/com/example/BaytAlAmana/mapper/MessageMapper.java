package com.example.BaytAlAmana.mapper;

import com.example.BaytAlAmana.dto.MessageDto;
import com.example.BaytAlAmana.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto toMessageDto(MessageEntity messageEntity);
    MessageEntity toMessageEntity(MessageDto messageDto);
    List<MessageDto> toMessageDtoList(List<MessageEntity> messageEntityList);
}
