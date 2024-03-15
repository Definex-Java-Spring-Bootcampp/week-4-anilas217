package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@SpringBootApplication
public class KredinbizdenServiceApplication {
    static Map<String, String> mailHashMap = new HashMap<>();
    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);

        List<Application> applicationListUser1;
        User user1 = null;
        if (checkUniqueEmail("cemdrman@gmail.com")) {
            user1 = User.createUser("Cem", "Dirman", LocalDate.of(1994, 3, 12), "cemdrman@gmail.com", "12345bjk", "05678902345", true, null);
        }
        List<Application> applicationListUser2;
        User user2 = null;
        if (checkUniqueEmail("anilarslan@gmail.com")) {
            user2 = User.createUser("Anil", "Arslan", LocalDate.of(1993, 3, 12), "anilarslan@gmail.com", "saaas", "05678902388", true, null);
        }
        List<Application> applicationListUser3;
        User user3 = null;
        if (checkUniqueEmail("semih48@gmail.com")) {
            user3 = User.createUser("Semih", "Yayık", LocalDate.of(1991, 3, 4), "semih48@gmail.com", "semih556677", "05678902334", true, null);
        }
        //-------------------------------------------------------------------------------//
        Bank garantiBank = Bank.createBank("Garanti",null,null);
        List<Loan> garantiloans = new ArrayList<>();
        Loan Garantiloan1 = Loan.createLoan(garantiBank, new BigDecimal("50.000"), 12, 4.8);
        Loan Garantiloan2 = Loan.createLoan(garantiBank, new BigDecimal("150.000"), 6, 3.2);
        Loan Garantiloan3 = Loan.createLoan(garantiBank, new BigDecimal("500.000"), 24, 2.4);

        garantiloans.add(Garantiloan1);
        garantiloans.add(Garantiloan2);
        garantiloans.add(Garantiloan3);

        List<Campaign> garantiCampainglistStudent = new ArrayList<>();
        List<Campaign> garantiCampainglistEntrepreneur = new ArrayList<>();
        List<Campaign> garantiCampainglistFlight = new ArrayList<>();

        Campaign Garanticampaign1 = Campaign.createCampaign("Bonus Genç","Student",LocalDate.of(2024,6,30),LocalDate.of(2024,3,15),LocalDate.of(2024,3,15),SectorType.OTHERS);
        Campaign Garanticampaign2 = Campaign.createCampaign("Genç Girisimci","Entrepreneur",LocalDate.of(2024,8,30),LocalDate.of(2024,3,15),LocalDate.of(2024,3,15),SectorType.MARKET);
        Campaign Garanticampaign3 = Campaign.createCampaign("Milci","Free Mil",LocalDate.of(2024,10,4),LocalDate.of(2024,3,14),LocalDate.of(2024,3,14),SectorType.TRAVELS);
        Campaign Garanticampaign4 = Campaign.createCampaign("Bonus Genç","New School",LocalDate.of(2024,6,30),LocalDate.of(2024,3,14),LocalDate.of(2024,3,14),SectorType.OTHERS);
        Campaign Garanticampaign5 = Campaign.createCampaign("Genç Girişimci","New Office",LocalDate.of(2024,8,30),LocalDate.of(2024,3,14),LocalDate.of(2024,3,14),SectorType.MARKET);
        Campaign Garanticampaign6 = Campaign.createCampaign("Genç Girişimci","Support",LocalDate.of(2024,8,30),LocalDate.of(2024,3,14),LocalDate.of(2024,3,14),SectorType.MARKET);


        garantiCampainglistStudent.add(Garanticampaign1);
        garantiCampainglistStudent.add(Garanticampaign4);

        garantiCampainglistEntrepreneur.add(Garanticampaign2);
        garantiCampainglistEntrepreneur.add(Garanticampaign5);
        garantiCampainglistEntrepreneur.add(Garanticampaign6);

        garantiCampainglistFlight.add(Garanticampaign3);

        List<CreditCard> garantiCreditCardLists = new ArrayList<>();
        CreditCard GaranticreditCard1 = CreditCard.createCreditCard(new BigDecimal("5.000"),garantiCampainglistStudent,garantiBank);
        CreditCard GaranticreditCard2 = CreditCard.createCreditCard(new BigDecimal("10.000"),garantiCampainglistFlight,garantiBank);
        CreditCard GaranticreditCard3 = CreditCard.createCreditCard(new BigDecimal("25.000"),garantiCampainglistEntrepreneur,garantiBank);

        garantiCreditCardLists.add(GaranticreditCard1);
        garantiCreditCardLists.add(GaranticreditCard2);
        garantiCreditCardLists.add(GaranticreditCard3);

        garantiBank.setLoanList(garantiloans);
        garantiBank.setCreditCards(garantiCreditCardLists);

        List<Application> applicationList = new ArrayList<>();
        List<Application> applicationList1 = new ArrayList<>();
        List<Application> applicationList2 = new ArrayList<>();
        List<Application> applicationList3 = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        Application application1 = Application.createLoanApplication(Garantiloan1,user1,null);
        Application application2 = Application.createLoanApplication(Garantiloan2,user1,null);
        Application application3 = Application.createLoanApplication(Garantiloan3,user1,null);
        applicationList1.add(application1);
        applicationList1.add(application2);
        applicationList1.add(application3);
        user1.setApplicationList(applicationList1);

        Application application4 = Application.createLoanApplication(Garantiloan1,user2,null);
        Application application5 = Application.createLoanApplication(Garantiloan2,user2,null);
        applicationList2.add(application4);
        applicationList2.add(application5);
        user2.setApplicationList(applicationList2);

        Application application6 = Application.createLoanApplication(Garantiloan1,user3,null);
        applicationList3.add(application6);
        user3.setApplicationList(applicationList3);

        applicationList.add(application1);
        applicationList.add(application2);
        applicationList.add(application3);
        applicationList.add(application4);
        applicationList.add(application5);
        applicationList.add(application6);

        //Finished to create and initial all the class
        //-------------------------------------------------------------------------------------------------//
        //Call procedures
        findMostAppliadUser(applicationList);
        findMostAppliadloanamount(applicationList);
        listofLastOneMonth(applicationList);
        listofCampaign(garantiCreditCardLists);
        cemdrmanTotalApplied(applicationList);
    }

    private static void listofCampaign(List<CreditCard> garantiCreditCardLists) {
        System.out.println("List of creditcard campaing descending");
        garantiCreditCardLists.sort((card1, card2) -> Integer.compare(card2.getCampaignList().size(), card1.getCampaignList().size()));
        for (CreditCard creditCard : garantiCreditCardLists) {
            List<Campaign> campaignList = creditCard.getCampaignList();
            for (Campaign campaign : campaignList) {
                System.out.println(campaign);
            }
        }
    }

    private static void cemdrmanTotalApplied(List<Application> applicationList) {
        List<Application> applists = new ArrayList<>();
        for (Application application: applicationList){
            User user = application.getUser();
            if (user.getEmail().contentEquals("cemdrman@gmail.com")){
                applists.add(application);
            }
        }
        System.out.println("cemdrman@gmail.com users has applied this applications: "+applists);
    }

    private static void listofLastOneMonth(List<Application> applicationList) {
        List<Application> applists = new ArrayList<>();
        for (Application application : applicationList) {
            LocalDateTime applicationDateTime = application.getLocalDateTime();
            long daysBetween = ChronoUnit.DAYS.between(applicationDateTime, LocalDateTime.now());
            if (daysBetween < 30) {
                applists.add(application);
            }
        }
        System.out.println("List of applicants in the last 1 month "+applists);
    }

    private static void findMostAppliadloanamount(List<Application> applicationList) {
        Set<User> user_set = new HashSet<>();
        for (Application application: applicationList){
            User user = application.getUser();

            user_set.add(user);
        }
        int maksloanamount = 0;
        User userOfAppliedMaksLoanAmount = User.getInstance();
        for (User user :user_set){
            List<Application> applicationLists = user.getApplicationList();
            int totalLoanAmount =0;
            for (Application application: applicationLists){
                Loan loan = application.getLoan();
                totalLoanAmount += loan.getAmount().intValue();
            }
            if (totalLoanAmount > maksloanamount){
                maksloanamount = totalLoanAmount;
                userOfAppliedMaksLoanAmount = user;
            }
        }
        System.out.println("Name of the user who requested the highest loan: "+userOfAppliedMaksLoanAmount.getName()+" Surname is: "+userOfAppliedMaksLoanAmount.getSurname()+" amount is: "+BigDecimal.valueOf(maksloanamount)+".000");
    }

    private static void findMostAppliadUser(List<Application> applicationList) {
        Map<User, Integer> userHashmap = new HashMap<>();
        for (Application application: applicationList){
            User user = application.getUser();
            userHashmap.put(user, userHashmap.getOrDefault(user, 0) + 1);
        }
        User mostAppliedUser = null;
        int maxApplications = 0;
        for (Map.Entry<User, Integer> entry : userHashmap.entrySet()) {
            if (entry.getValue() > maxApplications) {
                mostAppliedUser = entry.getKey();
                maxApplications = entry.getValue();
            }
        }
        System.out.println("Most applied user name is: "+mostAppliedUser.getName()+" surname is: "+mostAppliedUser.getSurname()+" amount of apply: "+maxApplications);
    }

    private static boolean checkUniqueEmail(String mail) {
        if (mailHashMap.get(mail) == null || mailHashMap.get(mail).isEmpty()){
            mailHashMap.put(mail, mail);
            return true;
        }
        else {
            System.out.println("Email is already exist!");
            return false;
        }

    }

}
