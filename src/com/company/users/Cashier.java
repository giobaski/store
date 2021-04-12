package com.company.users;

import java.util.Date;
import java.util.logging.Logger;

public class Cashier extends User {
    private String internalPhoneNumber;
    private double baseSalary;
    private double hoursOfWork;  // hoursOfWork is calculated based on the first login time and the last logout time of the day.
    private Date loginDateTime;  // int is for temporary use
    private Date logoutDateTime;  // int is for temporary use
    private double bonus;


    public Cashier(String name_surname, String username, String password, String address, String phoneNumber, String internalPhoneNumber) {
        super(name_surname, username, password, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
    }


    public void login(){
        Date loginTime = new Date();
        this.loginDateTime = loginTime;
        System.out.println("logged in at " + loginTime);
    }

    public void logout(){
        Date logoutTime = new Date();
        this.logoutDateTime = logoutTime;
        System.out.println("logged out at: " + logoutTime);
    }

    //Bonus is calculated as follows: for every hour overtime a bonus of 10 euro is given (8 hours is the normal work time).
    public double calculateBonus(){
        long timeMilliOfLogin = this.loginDateTime.getTime();
        long timeMilliOfLogout = this.logoutDateTime.getTime();
        this.hoursOfWork = (double)(timeMilliOfLogout-timeMilliOfLogin)/1000;

        if(hoursOfWork > 8){
            this.bonus = 10 * (hoursOfWork - 8);
        }

        //TODO: REMOVE THIS LOGS
        Logger logger = Logger.getLogger("com.company.users.Cashier");
        logger.warning("WARNING");
        logger.info("INFO");
        System.out.println("Hours of Work done by cashier: " + hoursOfWork);

        return this.bonus;
    }

}
