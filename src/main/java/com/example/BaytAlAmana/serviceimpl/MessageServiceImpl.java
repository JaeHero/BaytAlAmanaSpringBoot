package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.MessageDto;
import com.example.BaytAlAmana.entity.MessageEntity;
import com.example.BaytAlAmana.mapper.MessageMapper;
import com.example.BaytAlAmana.repo.MessageRepository;
import com.example.BaytAlAmana.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

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
        MessageEntity messageEntity = messageRepository.save(MessageMapper.INSTANCE.toMessageEntity(messageDto));
        return MessageMapper.INSTANCE.toMessageDto(messageEntity);
    }

    @Override
    public MessageDto updateMessage(int id, MessageDto messageDto) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(()->new RuntimeException("Message not found"));
        MessageEntity messageEntityToUpdate = MessageMapper.INSTANCE.toMessageEntity(messageDto);
        return MessageMapper.INSTANCE.toMessageDto(messageRepository.save(messageEntityToUpdate));
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
