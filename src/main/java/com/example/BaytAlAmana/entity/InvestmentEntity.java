package com.example.BaytAlAmana.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "investment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "funding")
    @Nullable
    private Integer funding;

    @Column(name = "funding_goal")
    private int fundingGoal;

    @Column(name = "date")
    private Date date;

    @Column(name = "expected_close_date")
    private Date expectedCloseDate;

    @Column(name = "investor_count")
    @Nullable
    private Integer investorCount;

    @OneToMany(mappedBy = "investmentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Indicates this is the "parent" side for serialization
    private List<InvestmentUpdateEntity> updates = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "investment_users", // Join table for users and investments
            joinColumns = @JoinColumn(name = "investment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<UserEntity> users = new HashSet<>();
}