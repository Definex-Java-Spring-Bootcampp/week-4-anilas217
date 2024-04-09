package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.ExceptionHandler.GlobalExceptionHandler;
import com.patika.kredinbizdenservice.Repository.BankRepository;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Loan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService implements IBankService {

    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    private final BankRepository bankRepository;

    public Bank save(Bank bank) {
        Bank bank1 = bankRepository.findByName(bank.getName());
        if (bank1 == null){
            return bankRepository.save(bank);
        }
        else{
            log.error("Bank already exist!!", bank1.getName());
            return null;
        }
    }

    @Override
    public List<Loan> getLoanList(String name) {
        Bank bank = bankRepository.findByName(name);
        if (bank != null) {
            return bank.getLoanList();
        } else {
            log.error("Bank not found with name: {}", name);
            return Collections.emptyList();
        }
    }


}
