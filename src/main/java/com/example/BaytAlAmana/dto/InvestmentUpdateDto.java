package com.example.BaytAlAmana.dto;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentUpdateDto {
    private int id;
    private int investmentId;
    private Date date;
    private int cost;
    private String description;
}
