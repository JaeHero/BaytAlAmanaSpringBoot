package com.example.BaytAlAmana.mapper;

import com.example.BaytAlAmana.dto.InvestmentImagesDTO;
import com.example.BaytAlAmana.entity.InvestmentImagesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InvestmentImagesMapper {
    InvestmentImagesMapper INSTANCE = Mappers.getMapper(InvestmentImagesMapper.class);

    InvestmentImagesDTO toInvestmentImagesDto(InvestmentImagesEntity investmentImagesEntity);
    InvestmentImagesEntity toInvestmentImages(InvestmentImagesDTO investmentImagesDto);
    List<InvestmentImagesDTO> toInvestmentImagesDtoList(List<InvestmentImagesEntity> investmentImagesEntity);
}
