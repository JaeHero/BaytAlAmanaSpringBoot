package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.InvestmentUpdateDto;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.entity.InvestmentUpdateEntity;
import com.example.BaytAlAmana.mapper.InvestmentUpdateMapper;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.repo.InvestmentUpdateRepository;
import com.example.BaytAlAmana.service.InvestmentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvestmentUpdateServiceImpl implements InvestmentUpdateService {

    @Autowired
    InvestmentUpdateRepository investmentUpdateRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Override
    public List<InvestmentUpdateDto> getAllInvestmentUpdates() {
        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDtoList(investmentUpdateRepository.findAll());
    }

    @Override
    public InvestmentUpdateDto getInvestmentUpdateById(int id) {
        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDto(investmentUpdateRepository.findById(id).orElseThrow(()->new RuntimeException("Investment Update not found")));
    }

    @Override
    public InvestmentUpdateDto createInvestmentUpdate(InvestmentUpdateDto investmentUpdateDto) {

        InvestmentEntity investment = investmentRepository.findById(investmentUpdateDto.getInvestmentId())
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        InvestmentUpdateEntity updateEntity = InvestmentUpdateMapper.INSTANCE.toInvestmentUpdate(investmentUpdateDto);

        updateEntity.setInvestmentEntity(investment);

        // Step 3: Save the update entity directly using InvestmentUpdateRepository
        InvestmentUpdateEntity savedUpdate = investmentUpdateRepository.save(updateEntity);

        // Step 4: Return the saved entity as a DTO
        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDto(savedUpdate);
    }


    @Override
    public InvestmentUpdateDto updateInvestmentUpdate(int id, InvestmentUpdateDto investmentUpdateDto) {
        // Step 1: Retrieve the existing update entity
        InvestmentUpdateEntity existingUpdateEntity = investmentUpdateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment Update not found"));

        InvestmentEntity investment = investmentRepository.findById(investmentUpdateDto.getInvestmentId())
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        InvestmentUpdateEntity updatedUpdateEntity = InvestmentUpdateMapper.INSTANCE.toInvestmentUpdate(investmentUpdateDto);

        updatedUpdateEntity.setId(existingUpdateEntity.getId());

        updatedUpdateEntity.setInvestmentEntity(investment);

        InvestmentUpdateEntity savedUpdate = investmentUpdateRepository.save(updatedUpdateEntity);

        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDto(savedUpdate);
    }

    @Override
    public boolean deleteInvestmentUpdate(int id) {
        try {
            investmentUpdateRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
