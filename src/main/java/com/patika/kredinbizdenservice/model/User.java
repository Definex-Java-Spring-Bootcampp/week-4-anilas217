package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.model.constants.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column (name = UserEntity.name,unique = false,nullable = false)
    private String name;

    @Column (name = UserEntity.surname,unique = false,nullable = false)
    private String surname;

    @Column (name = UserEntity.birth_date,unique = false,nullable = false)
    private LocalDate birthDate;

    @Column (name = UserEntity.email,unique = true,nullable = false)
    private String email; //bir email ile bir kere kayıt olunabilir.

    @Column (name = UserEntity.password,unique = false,nullable = false)
    private String password; //hash fonskiyonlarından biri ile hashlanecek.

    @Column (name = UserEntity.phoneNumber,unique = true,nullable = false)
    private String phoneNumber;

    @Column (name = UserEntity.isActive,unique = false,nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Application> applicationList;



}
