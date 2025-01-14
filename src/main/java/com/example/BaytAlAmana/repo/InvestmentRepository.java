package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity, String> {
}
