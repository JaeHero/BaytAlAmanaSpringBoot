package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.InvestmentUpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentUpdateRepository extends JpaRepository<InvestmentUpdateEntity, Integer> {
}
