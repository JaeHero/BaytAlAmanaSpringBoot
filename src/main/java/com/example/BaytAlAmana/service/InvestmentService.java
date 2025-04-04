package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface InvestmentService {
    List<InvestmentDTO> getAllInvestments();
    InvestmentDTO getInvestmentById(int id);
    InvestmentDTO createInvestment(InvestmentDTO investmentDTO);
    InvestmentDTO updateInvestment(int id, InvestmentDTO investmentDTO);
    boolean deleteInvestment(int id);
    List<InvestmentDTO> getUserInvestments(int id);
    List<InvestmentDTO> getAvailableInvestments(int id);
    
}
