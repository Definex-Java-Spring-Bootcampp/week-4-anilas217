package com.patika.kredinbizdenservice.Repository;

import com.patika.kredinbizdenservice.Service.IBankService;
import com.patika.kredinbizdenservice.model.Bank;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByName(String name);
}
