package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.InvestmentImagesDTO;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.entity.InvestmentImagesEntity;
import com.example.BaytAlAmana.mapper.InvestmentImagesMapper;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.repo.InvestmentImagesRepository;
import com.example.BaytAlAmana.service.InvestmentImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvestmentImagesServiceImpl implements InvestmentImagesService {

    @Autowired
    InvestmentImagesRepository investmentImagesRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Override
    public List<InvestmentImagesDTO> getAllInvestmentImages() {
        return InvestmentImagesMapper.INSTANCE.toInvestmentImagesDtoList(investmentImagesRepository.findAll());
    }

    @Override
    public InvestmentImagesDTO getInvestmentImageById(int id) {
        return InvestmentImagesMapper.INSTANCE.toInvestmentImagesDto(investmentImagesRepository.findById(id).orElseThrow(()->new RuntimeException("Investment Image not found")));
    }

    @Override
    public InvestmentImagesDTO createInvestmentImage(InvestmentImagesDTO investmentImagesDTO) {

        InvestmentEntity investment = investmentRepository.findById(investmentImagesDTO.getInvestmentId())
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        InvestmentImagesEntity imageEntity = InvestmentImagesMapper.INSTANCE.toInvestmentImages(investmentImagesDTO);

        imageEntity.setInvestmentEntity(investment);

        InvestmentImagesEntity savedImage = investmentImagesRepository.save(imageEntity);

        InvestmentImagesDTO image = InvestmentImagesMapper.INSTANCE.toInvestmentImagesDto(savedImage);
        image.setInvestmentId(investmentImagesDTO.getInvestmentId());

        return image;
    }


    @Override
    public InvestmentImagesDTO updateInvestmentImage(int id, InvestmentImagesDTO investmentImagesDTO) {
        // Step 1: Retrieve the existing image entity
        InvestmentImagesEntity existingImageEntity = investmentImagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment Image not found"));

        InvestmentEntity investment = investmentRepository.findById(investmentImagesDTO.getInvestmentId())
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        InvestmentImagesEntity updatedImageEntity = InvestmentImagesMapper.INSTANCE.toInvestmentImages(investmentImagesDTO);

        updatedImageEntity.setId(existingImageEntity.getId());

        updatedImageEntity.setInvestmentEntity(investment);

        InvestmentImagesEntity savedImage = investmentImagesRepository.save(updatedImageEntity);

        return InvestmentImagesMapper.INSTANCE.toInvestmentImagesDto(savedImage);
    }

    @Override
    public boolean deleteInvestmentImage(int id) {
        try {
            investmentImagesRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
