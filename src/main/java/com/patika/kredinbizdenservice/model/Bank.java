package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.constants.BankEntity;
import com.patika.kredinbizdenservice.model.constants.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static com.patika.kredinbizdenservice.model.constants.BankEntity.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = BankEntity.name,unique = false,nullable = false)
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Loan> loanList;

    @OneToMany(mappedBy = "bank")
    private List<CreditCard> creditCards;


}
