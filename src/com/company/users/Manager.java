package com.company.users;

public class Manager extends User {
    private String internalPhoneNumber;
    private String Pin;  //Every manager has his own PIN to start the software. The start can be made after the login.


    public Manager(String name_surname, String username, String password, String address, String phoneNumber) {
        super(name_surname, username, password, address, phoneNumber);
    }
}
