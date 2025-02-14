package com.example.BaytAlAmana.repo;

import com.example.BaytAlAmana.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
}
