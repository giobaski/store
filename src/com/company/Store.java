package com.company;

import com.company.baskets.Basket;
import com.company.users.Cashier;
import com.company.users.Manager;
import com.company.users.User;

import java.util.*;

public class Store {
    private String address;
    Manager manager;
    private Cashier currentCashier;
    private Menu menu;
    public static ArrayList<Cashier> cashiers;
    public static ArrayList<Basket> currentBaskets;
    public static ArrayList<Basket> servedBaskets;
    public static ResourceBundle bundle;

    public Store(String address) {
        this.address = address;
        servedBaskets = new ArrayList<>();
        currentBaskets = new ArrayList<>();
        cashiers = new ArrayList<>();
        //TODO:create this list outside the constructor
        cashiers.addAll(List.of(
                new Cashier("Cashier01", "username1", "password1","address1",
                "+372111111", "0001"),
                new Cashier("Cashier02", "username2", "password2","address1",
                        "+3722222", "0002")
                ));
        //Set language for application
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose your language: 1 - English, 2 - German");
        int languageCode = input.nextInt();
        this.bundle = setLanguageAndGetBundle(languageCode);
    }

    //internationalization i18n
    public ResourceBundle setLanguageAndGetBundle(int languageCode){
        Locale locale = Locale.US;
        switch(languageCode){
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("de", "DE");
                break;
            default:
                locale = new Locale("en", "US");
        }

        bundle = ResourceBundle.getBundle("com/company/Messages", locale);
        return bundle;
    }


    public Cashier cashierAuthentication() {
        //Cashier has to Login into menu, ask for credentials
        Scanner input = new Scanner(System.in);
        System.out.println(this.bundle.getString("loginText"));

        System.out.print(this.bundle.getString("username") + ": ");
        String username = input.nextLine();  // Read username

        System.out.print(this.bundle.getString("password") + ": ");
        String password = input.nextLine();  // Read password


        //Check username and password against predefined cashiers lists in a Store class.
        Optional<Cashier> cashier = this.cashiers.stream()
                .filter(x -> x.getUsername().equals(username))
                .filter(x -> x.getPassword().equals(password))
                .findFirst();

        //If cashier logs in successfully, Open new Menu
        if (cashier.isPresent()) {
            this.currentCashier = cashier.get();
            this.currentCashier.login();
        }
        return this.currentCashier;
    }


    //
    public Menu openMenu(){
        return new Menu(this.address, this.currentCashier);
    }



    public static ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public String getAddress() {
        return address;
    }

    public static ArrayList<Basket> getCurrentBaskets() {
        return currentBaskets;
    }

    public static ArrayList<Basket> getServedBaskets() {
        return servedBaskets;
    }
}
