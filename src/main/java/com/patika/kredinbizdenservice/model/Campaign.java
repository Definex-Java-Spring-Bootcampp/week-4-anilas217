package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;

import java.time.LocalDate;

import com.patika.kredinbizdenservice.model.constants.CampaingEntity;
import com.patika.kredinbizdenservice.model.constants.LoanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = CampaingEntity.title,unique = false,nullable = false)
    private String title;

    @Column (name = CampaingEntity.content,unique = false,nullable = false)
    private String content;

    @Column (name = CampaingEntity.dueDate,unique = false,nullable = false)
    private LocalDate dueDate;

    @Column (name = CampaingEntity.createDate,unique = false,nullable = false)
    private LocalDate createDate;

    @Column (name = CampaingEntity.updateDate,unique = false,nullable = false)
    private LocalDate updateDate;

    @Column (name = CampaingEntity.sector,unique = false,nullable = false)
    private SectorType sector;


}
