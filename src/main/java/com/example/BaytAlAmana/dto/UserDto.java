package com.example.BaytAlAmana.dto;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.entity.MessageEntity;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
public class UserDto {
    //One to many
    private int id;
    private List<MessageEntity> messages;
    private String username;
    private String email;
    private String phone;
    private String passwordHash;
    private int investmentCount;
    private int profit;
    private int intendedInvestment;
    private boolean isAdmin;
    private boolean isApproved;
    private boolean isPublic;
    private LocalDate creationDate;
    private int totalInvestment;
//    private int investedAmount;
   // private Set<InvestmentEntity> investments;
}