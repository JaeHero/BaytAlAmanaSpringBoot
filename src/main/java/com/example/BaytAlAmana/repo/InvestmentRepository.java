package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity, Integer> {
    @Query("SELECT i FROM InvestmentEntity i JOIN i.users u WHERE u.id = :userId")
    List<InvestmentEntity> findInvestmentsByUserId(int userId);

}
