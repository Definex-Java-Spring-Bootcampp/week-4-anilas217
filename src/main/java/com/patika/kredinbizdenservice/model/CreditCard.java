package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.constants.BankEntity;
import com.patika.kredinbizdenservice.model.constants.CreditCardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="CreditCard")
public class CreditCard implements Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = CreditCardEntity.fee,unique = false,nullable = false)
    private BigDecimal fee;

    @ManyToOne
    @JoinColumn(name = "campaing_id")
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

}

