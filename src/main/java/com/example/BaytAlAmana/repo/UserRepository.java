package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT investment_amount FROM investment_users WHERE user_id = :userId AND investment_id = :investmentId", nativeQuery = true)
    Optional<Integer> findInvestmentAmount(@Param("userId") int userId, @Param("investmentId") int investmentId);

    @Modifying
    @Query(value = "INSERT INTO investment_users (investment_id, user_id, investment_amount) VALUES (:investmentId, :userId, :investmentAmount)", nativeQuery = true)
    void saveUserInvestmentAmount(@Param("investmentId") int investmentId,
                            @Param("userId") int userId,
                            @Param("investmentAmount") int investmentAmount);

}
