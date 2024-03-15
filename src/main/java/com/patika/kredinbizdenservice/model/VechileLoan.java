package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VechileStatuType;

import java.math.BigDecimal;

public class VechileLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VechileStatuType vechileStatuType;

    public VechileLoan() {

    }

    public VechileLoan(Bank bank, BigDecimal amount, Integer installment, Double interestRate) {
        super(bank, amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public VechileStatuType getVechileStatuType() {
        return vechileStatuType;
    }

    public void setVechileStatuType(VechileStatuType vechileStatuType) {
        this.vechileStatuType = vechileStatuType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        // Calculate logic specific to vehicle loans
    }
}
