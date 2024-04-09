package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import com.patika.kredinbizdenservice.model.constants.ApplicationEntity;
import com.patika.kredinbizdenservice.model.constants.BankEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Application")
public class Application extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 /*  @OneToOne
    private Loan loan;  */

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = ApplicationEntity.localDateTime,unique = false,nullable = false)
    private LocalDateTime localDateTime;

    @Column (name = ApplicationEntity.application_status,unique = false,nullable = false)
    private ApplicationStatus applicationStatus;

}
