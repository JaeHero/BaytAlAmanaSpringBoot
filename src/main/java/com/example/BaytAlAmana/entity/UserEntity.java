package com.example.BaytAlAmana.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in MessageEntity
    private List<MessageEntity> messages;

    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in InvestmentEntity
    private List<InvestmentEntity> investments;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "investment_count")
    private int investmentCount;

    @Column(name = "profit")
    private int profit;

    @Column(name = "intended_investment")
    private int intendedInvestment;
}