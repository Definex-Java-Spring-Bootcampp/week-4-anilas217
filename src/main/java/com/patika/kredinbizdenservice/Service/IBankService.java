package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Loan;

import java.util.List;

public interface IBankService {

    Bank save(Bank bank);

    List<Loan> getLoanList(String name);
}
