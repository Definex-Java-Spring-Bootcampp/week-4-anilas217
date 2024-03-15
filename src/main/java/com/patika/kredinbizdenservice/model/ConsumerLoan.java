package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(Bank bank, BigDecimal amount, Integer installment, Double interestRate) {
        super(bank, amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        // Calculate logic specific to consumer loans
    }

    public List<Integer> getInstallmentOptions() {
        return installmentOptions;
    }

    public void setInstallmentOptions(List<Integer> installmentOptions) {
        this.installmentOptions = installmentOptions;
    }

    public static ConsumerLoan createConsumerLoan(Bank bank, BigDecimal amount, Integer installment, Double interestRate, List<Integer> installmentOptions) {
        ConsumerLoan consumerLoan = new ConsumerLoan(bank, amount, installment, interestRate);
        consumerLoan.setInstallmentOptions(installmentOptions);
        return consumerLoan;
    }
}
