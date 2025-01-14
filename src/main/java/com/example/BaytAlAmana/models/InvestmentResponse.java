package com.example.BaytAlAmana.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InvestmentResponse {
    private int id;
    private String name;
    private String status;
    private String location;
    private int funding;
    private int fundingGoal;
    private String date;
    private String expectedCloseDate;

}
