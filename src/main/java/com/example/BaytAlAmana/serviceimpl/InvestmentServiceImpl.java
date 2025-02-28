package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.mapper.InvestmentMapper;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    InvestmentRepository investmentRepository;

    @Override
    public List<InvestmentDTO> getAllInvestments() {
        return InvestmentMapper.INSTANCE.toInvestmentDTOList(investmentRepository.findAll());
    }

    @Override
    public InvestmentDTO getInvestmentById(int       id) {
        return InvestmentMapper.INSTANCE.toInvestmentDTO(investmentRepository.findById(id).orElseThrow(()->new RuntimeException("Investment not found")));
    }

    @Override
    public InvestmentDTO createInvestment(InvestmentDTO investmentDTO) {
        InvestmentEntity investmentEntity = investmentRepository.save(InvestmentMapper.INSTANCE.toInvestmentEntity(investmentDTO));
        return InvestmentMapper.INSTANCE.toInvestmentDTO(investmentEntity);
    }

    @Override
    public InvestmentDTO updateInvestment(int id, InvestmentDTO investmentDTO) {
        InvestmentEntity investmentEntity = investmentRepository.findById(id).orElseThrow(()->new RuntimeException("Investment not found"));
        InvestmentEntity investmentEntityToUpdate = InvestmentMapper.INSTANCE.toInvestmentEntity(investmentDTO);
        investmentEntityToUpdate.setId(id);
        return InvestmentMapper.INSTANCE.toInvestmentDTO(investmentRepository.save(investmentEntityToUpdate));
    }

    @Override
    public boolean deleteInvestment(int id) {
        try {
            investmentRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
