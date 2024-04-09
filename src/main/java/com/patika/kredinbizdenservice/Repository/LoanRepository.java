package com.patika.kredinbizdenservice.Repository;

import com.patika.kredinbizdenservice.model.Loan;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository {
    Loan save(Loan loan);
}
