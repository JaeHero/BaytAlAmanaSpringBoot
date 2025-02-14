package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
