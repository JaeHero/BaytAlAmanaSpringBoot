package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.entity.UserEntity;
import com.example.BaytAlAmana.mapper.InvestmentMapper;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<InvestmentDTO> getUserInvestments(int id) {
//        List<InvestmentEntity> investments = investmentRepository.findAll();
//        List<InvestmentEntity> userInvestments = new ArrayList<>();
//        for(InvestmentEntity investment : investments){
//            for(UserEntity user: investment.getUsers()){
//                if(user.getId() == id){
//                    userInvestments.add(investment);
//                }
//            }
//        }
//        return InvestmentMapper.INSTANCE.toInvestmentDTOList(userInvestments);
        return InvestmentMapper.INSTANCE.toInvestmentDTOList(investmentRepository.findInvestmentsByUserId(id));
    }
    @Override
    public List<InvestmentDTO> getAvailableInvestments(int id){
            List<InvestmentDTO> userInvestments = getUserInvestments(id);
            List<InvestmentDTO> allInvestments = getAllInvestments();
            List<InvestmentDTO> remainingInvestments = new ArrayList<>();

            Set<Integer> userInvestmentIds = userInvestments.stream()
                    .map(InvestmentDTO::getId)
                    .collect(Collectors.toSet());

            for (InvestmentDTO investment : allInvestments) {
                if (!userInvestmentIds.contains(investment.getId())) {
                    remainingInvestments.add(investment);
                }
            }
            return remainingInvestments;
        }

    }

