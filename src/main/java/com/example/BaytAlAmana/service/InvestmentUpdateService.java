package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.InvestmentUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InvestmentUpdateService {
    List<InvestmentUpdateDto> getAllInvestmentUpdates();
    InvestmentUpdateDto getInvestmentUpdateById(int id);
    InvestmentUpdateDto createInvestmentUpdate(InvestmentUpdateDto investmentUpdateDto);
    InvestmentUpdateDto updateInvestmentUpdate(int id, InvestmentUpdateDto investmentUpdateDto);
    boolean deleteInvestmentUpdate(int id);
}
