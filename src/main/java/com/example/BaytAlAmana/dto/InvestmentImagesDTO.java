package com.example.BaytAlAmana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentImagesDTO {
    private int id;
    private int investmentId;
    private String title;
    private LocalDate creationDate;
    private String URL;
}
