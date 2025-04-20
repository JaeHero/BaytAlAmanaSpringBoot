package com.example.BaytAlAmana.service;

import com.example.BaytAlAmana.dto.InvestmentImagesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InvestmentImagesService {
    List<InvestmentImagesDTO> getAllInvestmentImages();
    InvestmentImagesDTO getInvestmentImageById(int id);
    InvestmentImagesDTO createInvestmentImage(InvestmentImagesDTO investmentImagesDto);
    InvestmentImagesDTO updateInvestmentImage(int id, InvestmentImagesDTO investmentImagesDto);
    boolean deleteInvestmentImage(int id);
}
