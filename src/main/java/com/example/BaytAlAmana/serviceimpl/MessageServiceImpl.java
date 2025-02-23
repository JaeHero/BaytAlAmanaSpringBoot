package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.MessageDto;
import com.example.BaytAlAmana.entity.MessageEntity;
import com.example.BaytAlAmana.entity.UserEntity;
import com.example.BaytAlAmana.mapper.MessageMapper;
import com.example.BaytAlAmana.repo.MessageRepository;
import com.example.BaytAlAmana.repo.UserRepository;
import com.example.BaytAlAmana.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<MessageDto> getAllMessages() {
        return MessageMapper.INSTANCE.toMessageDtoList(messageRepository.findAll());
    }

    @Override
    public MessageDto getMessageById(int id) {
        return MessageMapper.INSTANCE.toMessageDto(messageRepository.findById(id).orElseThrow(()->new RuntimeException("Message not found")));
    }

    @Override
    public MessageDto createMessage(MessageDto messageDto) {
        UserEntity user = userRepository.findById(messageDto.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        MessageEntity messageEntityNew = MessageMapper.INSTANCE.toMessageEntity(messageDto);
        messageEntityNew.setUserEntity(user);
        MessageEntity savedMessage = messageRepository.save(messageEntityNew);
        return MessageMapper.INSTANCE.toMessageDto(savedMessage);
    }

    @Override
    public MessageDto updateMessage(int id, MessageDto messageDto) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(()->new RuntimeException("Message not found"));
        UserEntity user = userRepository.findById(messageDto.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        MessageEntity updatedMessage = MessageMapper.INSTANCE.toMessageEntity(messageDto);
        updatedMessage.setUserEntity(user);
        updatedMessage.setId(messageEntity.getId());
        MessageEntity savedMessage = messageRepository.save(updatedMessage);
        return MessageMapper.INSTANCE.toMessageDto(savedMessage);
    }

    @Override
    public boolean deleteMessage(int id) {
        try{
            messageRepository.deleteById(id);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
