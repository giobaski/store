package com.company.users;

public class User {
    private int id;
    private String name_surname;
    private String username;
    private String password;
    private String address;
    private String PhoneNumber;

    private static int nextNumber;

    public User(String name_surname, String username, String password, String address, String phoneNumber) {
        this.id = ++nextNumber;
        this.name_surname = name_surname;
        this.username = username;
        this.password = password;
        this.address = address;
        PhoneNumber = phoneNumber;
    }


    //Getters
    public int getId() {
        return id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public static int getNextNumber() {
        return nextNumber;
    }
}
