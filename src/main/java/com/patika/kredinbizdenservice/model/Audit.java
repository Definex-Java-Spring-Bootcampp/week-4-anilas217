package com.patika.kredinbizdenservice.model;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Audit {

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
