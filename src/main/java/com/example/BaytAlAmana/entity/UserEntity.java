package com.example.BaytAlAmana.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MessageEntity> messages = new ArrayList<>();

//    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in MessageEntity
//    private List<MessageEntity> messages;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in InvestmentEntity
    private Set<InvestmentEntity> investments = new HashSet<>();

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