package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;

import java.time.LocalDateTime;

public class Application {
    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    private Application() {
    }

    public static Application createLoanApplication(Loan loan, User user, LocalDateTime localDateTime) {
        Application application = new Application();
        application.setLoan(loan);
        application.setUser(user);
        application.setLocalDateTime(localDateTime.now());
        application.setApplicationStatus(ApplicationStatus.INITIAL);
        return application;
    }

    public static Application createProductApplication(Product product, User user, LocalDateTime localDateTime) {
        Application application = new Application();
        application.setProduct(product);
        application.setUser(user);
        application.setLocalDateTime(localDateTime.now());
        application.setApplicationStatus(ApplicationStatus.INITIAL);
        return application;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", product=" + product +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
