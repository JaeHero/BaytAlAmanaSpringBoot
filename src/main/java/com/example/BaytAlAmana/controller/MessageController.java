package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.dto.MessageDto;
import com.example.BaytAlAmana.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("messages")
    public ResponseEntity<List<MessageDto>> getAllMessages(){
        return ResponseEntity.ok().body(messageService.getAllMessages());
    }
    @GetMapping("message/{id}")
    public ResponseEntity<MessageDto> getMessageById(@PathVariable int id){
        return ResponseEntity.ok().body(messageService.getMessageById(id));
    }
    @PostMapping("message")
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto messageDto){
        return ResponseEntity.ok().body(messageService.createMessage(messageDto));
    }
    @PutMapping("message/{id}")
    public ResponseEntity<MessageDto> updateMessage(@PathVariable int id, @RequestBody MessageDto messageDto){
        return ResponseEntity.ok().body(messageService.updateMessage(id, messageDto));
    }
    @DeleteMapping("message/{id}")
    public ResponseEntity<Boolean> deleteMessage(@PathVariable int id){
        return ResponseEntity.ok().body(messageService.deleteMessage(id));
    }
}
