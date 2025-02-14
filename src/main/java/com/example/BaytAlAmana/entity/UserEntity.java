package com.example.BaytAlAmana.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "user")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
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
