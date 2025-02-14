package com.example.BaytAlAmana.mapper;

import com.example.BaytAlAmana.dto.InvestmentUpdateDto;
import com.example.BaytAlAmana.entity.InvestmentUpdateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InvestmentUpdateMapper {
    InvestmentUpdateMapper INSTANCE = Mappers.getMapper(InvestmentUpdateMapper.class);

    InvestmentUpdateDto toInvestmentUpdateDto(InvestmentUpdateEntity investmentUpdateEntity);
    InvestmentUpdateEntity toInvestmentUpdate(InvestmentUpdateDto investmentUpdateDto);
    List<InvestmentUpdateDto> toInvestmentUpdateDtoList(List<InvestmentUpdateEntity> investmentUpdateEntity);
}
