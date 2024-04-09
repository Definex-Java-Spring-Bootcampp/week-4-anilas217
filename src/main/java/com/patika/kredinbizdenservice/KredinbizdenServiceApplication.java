package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaServer
@SpringBootApplication

public class KredinbizdenServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);


    }
}
