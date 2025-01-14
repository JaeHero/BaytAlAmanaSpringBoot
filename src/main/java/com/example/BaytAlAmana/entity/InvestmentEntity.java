package com.example.BaytAlAmana.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "investment")
@Data
public class InvestmentEntity {
    @Id
    @Column(name = "INVESTMENT_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "FUNDING")
    private int funding;

    @Column(name = "FUNDING_GOAL")
    private int fundingGoal;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "EXPECTED_CLOSE_DATE")
    private Date expectedCloseDate;

    @Column(name = "INVESTOR_COUNT")
    @Nullable
    private int investorCount;



}
