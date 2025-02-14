package com.example.BaytAlAmana.dto;

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
    private int updateId;
    private Date date;
    private int cost;
    private String update;
}
