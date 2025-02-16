package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.InvestmentUpdateDto;
import com.example.BaytAlAmana.entity.InvestmentUpdateEntity;
import com.example.BaytAlAmana.mapper.InvestmentUpdateMapper;
import com.example.BaytAlAmana.repo.InvestmentUpdateRepository;
import com.example.BaytAlAmana.service.InvestmentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvestmentUpdateServiceImpl implements InvestmentUpdateService {

    @Autowired
    InvestmentUpdateRepository investmentUpdateRepository;

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
        InvestmentUpdateEntity investmentUpdateEntity = investmentUpdateRepository.save(InvestmentUpdateMapper.INSTANCE.toInvestmentUpdate(investmentUpdateDto));
        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDto(investmentUpdateEntity);
    }

    @Override
    public InvestmentUpdateDto updateInvestmentUpdate(int id, InvestmentUpdateDto investmentUpdateDto) {
        InvestmentUpdateEntity investmentUpdateEntity = investmentUpdateRepository.findById(id).orElseThrow(()->new RuntimeException("Investment Update not found"));
        InvestmentUpdateEntity investmentUpdateEntityToUpdate = InvestmentUpdateMapper.INSTANCE.toInvestmentUpdate(investmentUpdateDto);
        return InvestmentUpdateMapper.INSTANCE.toInvestmentUpdateDto(investmentUpdateRepository.save(investmentUpdateEntityToUpdate));
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
