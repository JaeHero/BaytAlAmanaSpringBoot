package com.example.BaytAlAmana.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "investmentUpdate")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentUpdateEntity {
   private int updateId;
   private Date date;
   private int cost;
   private String update;




}
