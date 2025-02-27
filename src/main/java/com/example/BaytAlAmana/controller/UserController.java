package com.example.BaytAlAmana.controller;

import com.example.BaytAlAmana.dto.UserDto;
import com.example.BaytAlAmana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baytalamana")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
    @PostMapping("user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }
    @PutMapping("user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto userDto){
        return ResponseEntity.ok().body(userService.updateUser(id, userDto));
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @PutMapping("user/{id}/investment/{investmentId}")
    public ResponseEntity<Boolean> assignUserToInvestment(@PathVariable int id, @PathVariable int investmentId){
        return ResponseEntity.ok().body(userService.assignUserToInvestment(id, investmentId));
    }
}
