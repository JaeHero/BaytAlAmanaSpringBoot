package com.example.BaytAlAmana.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
    private int status;

    @Column(name = "location")
    private String location;

    @Column(name = "funding")
    @Nullable
    private int funding;

    @Column(name = "funding_goal")
    private int fundingGoal;

    @Column(name = "date")
    private Date date;

    @Column(name = "expected_close_date")
    private Date expectedCloseDate;

    @Column(name = "investor_count")
    @Nullable
    private int investorCount;

    @Column(name = "expenditures")
    @Nullable
    private int expenditures;

    @Column(name = "duration")
    @Nullable
    private int duration;

    @Column(name = "profit")
    @Nullable
    private int profit;

    @OneToMany(mappedBy = "investmentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
     // Indicates this is the "parent" side for serialization
    private List<InvestmentUpdateEntity> updates = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "investment_users", // Join table for users and investments
            joinColumns = @JoinColumn(name = "investment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<UserEntity> users = new HashSet<>();
}