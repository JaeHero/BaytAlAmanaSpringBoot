package com.example.BaytAlAmana.dto;

import com.example.BaytAlAmana.entity.InvestmentUpdateEntity;
import com.example.BaytAlAmana.entity.UserEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentDTO {

    private int id;

    private String name;

    private int status;

    private String location;

    private int funding;

    private int fundingGoal;

    private Date date;

    private Date expectedCloseDate;

    private int investorCount;

    private List<InvestmentUpdateEntity> updates;

    private Set<UserEntity> users;
}
