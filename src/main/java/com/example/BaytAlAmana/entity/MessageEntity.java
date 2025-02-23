package com.example.BaytAlAmana.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity userEntity;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;
}