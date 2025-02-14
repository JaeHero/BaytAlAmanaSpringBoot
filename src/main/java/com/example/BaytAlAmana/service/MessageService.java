package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getAllMessages();
    MessageDto getMessageById(int id);
    MessageDto createMessage(MessageDto messageDto);
    MessageDto updateMessage(int id, MessageDto messageDto);
    boolean deleteMessage(int id);
}
