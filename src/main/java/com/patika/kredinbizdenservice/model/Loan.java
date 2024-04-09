package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.constants.LoanEntity;
import com.patika.kredinbizdenservice.model.constants.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Loan")
@Inheritance(strategy = InheritanceType.JOINED)
public class Loan implements Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = LoanEntity.amount, unique = false, nullable = false)
    private BigDecimal amount;

    @Column(name = LoanEntity.installment, unique = false, nullable = false)
    private Integer installment;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Column(name = LoanEntity.interest_rate, unique = false, nullable = false)
    private Double interest_rate;


}

