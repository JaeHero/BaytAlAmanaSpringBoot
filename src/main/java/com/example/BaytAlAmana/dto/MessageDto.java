package com.example.BaytAlAmana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private int messageId;
    private String message;
    private Date date;
}
