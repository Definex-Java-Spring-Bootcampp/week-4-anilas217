package com.patika.kredinbizdenservice;
import com.patika.kredinbizdenservice.Repository.BankRepository;
import com.patika.kredinbizdenservice.Service.BankService;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BankServiceTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Bank bank = new Bank();
        bank.setName("Test Bank");

        when(bankRepository.findByName(bank.getName())).thenReturn(null);

        when(bankRepository.save(bank)).thenReturn(bank);

        Bank result = bankService.save(bank);

        assertEquals(bank, result);
    }

    @Test
    public void testGetLoanList() {
        Bank bank = new Bank();
        bank.setName("Test Bank");

        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan());

        when(bankRepository.findByName(bank.getName())).thenReturn(bank);

        List<Loan> result = bankService.getLoanList(bank.getName());

        assertEquals(loans.size(), result.size());
    }
}
