package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public Bank(String name, List<Loan> loanList, List<CreditCard> creditCards) {

    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", loanList=" + loanList +
                '}';
    }
    public static Bank createBank(String name, List<Loan> loanList, List<CreditCard> creditCards) {
        return new Bank(name, loanList, creditCards);
    }
}
