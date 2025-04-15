package com.example.BaytAlAmana.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
    private List<MessageEntity> messages = new ArrayList<>();

//    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in MessageEntity
//    private List<MessageEntity> messages;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "users") // Relation mapped by the "users" list in InvestmentEntity
    @JsonIgnore
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

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "total_investment")
    private int totalInvestment;

}