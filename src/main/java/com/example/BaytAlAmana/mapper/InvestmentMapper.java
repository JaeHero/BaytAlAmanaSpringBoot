package com.example.BaytAlAmana.mapper;

import com.example.BaytAlAmana.dto.InvestmentDTO;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InvestmentMapper {
    InvestmentMapper INSTANCE = Mappers.getMapper(InvestmentMapper.class);

    InvestmentDTO toInvestmentDTO(InvestmentEntity investmentEntity);
    InvestmentEntity toInvestmentEntity(InvestmentDTO investmentDTO);
    List<InvestmentDTO> toInvestmentDTOList(List<InvestmentEntity> investmentEntityList);
}
