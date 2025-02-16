package com.example.BaytAlAmana.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "investment_update")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentUpdateEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne
   @JoinColumn(name = "investment_id")
   private InvestmentEntity investmentEntity;

   @Column(name = "date")
   private Date date;

   @Column(name = "cost")
   private int cost;

   @Column(name = "description")
   private String description;
}