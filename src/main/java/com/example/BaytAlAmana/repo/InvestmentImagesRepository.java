package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.InvestmentImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentImagesRepository extends JpaRepository<InvestmentImagesEntity, Integer> {
}
