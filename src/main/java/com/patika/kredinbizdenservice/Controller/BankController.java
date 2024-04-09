package com.patika.kredinbizdenservice.Controller;

import com.patika.kredinbizdenservice.Service.IBankService;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    IBankService bankService;
    public BankController(IBankService bankService) {
        this.bankService = bankService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody Bank bank) {

        return bankService.save(bank);
    }
    @GetMapping("/{name}")
    public List<Loan> getLoanlist(@PathVariable String name) {
        return (List<Loan>) bankService.getLoanList(name);
    }


}
