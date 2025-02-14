package com.example.BaytAlAmana.dto;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
public class UserDto {
    private int userID;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String passwordHash;
    private int investmentCount;
    private int profit;
    private int intendedInvestment;
    private boolean admin;
    private boolean approved;
    private boolean isPublic;
    private List<InvestmentEntity> investments;
    private List<InvestmentEntity> savedInvestments;
}
