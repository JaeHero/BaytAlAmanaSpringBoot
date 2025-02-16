package com.example.BaytAlAmana.dto;

import com.example.BaytAlAmana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private int id;
    private List<UserEntity> users;
    private String message;
    private Date date;
}
