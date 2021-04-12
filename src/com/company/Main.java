package com.company;

import com.company.baskets.Basket;
import com.company.items.BuyMorePayLess;
import com.company.items.DiscountIndependence;
import com.company.items.Item;
import com.company.items.ItemWithDiscount;
import com.company.users.Cashier;
import com.company.users.LoyalCustomer;
import com.company.users.User;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //I T E M S
        Item item1 = new Item("Coca-cola", 200);
        System.out.println("Price before discount: " + item1.getPrice());
        System.out.println("Price after discount: " + item1.calculateDiscount());  //should be same price, 200, there's no doscount for this type

        ItemWithDiscount item2 = new ItemWithDiscount("Coca-cola Zero", 2.0);
        System.out.println("\nPrice before discount: " + item2.getPrice());
        item2.setDiscount(10);
        System.out.println("Price after discount: " + item2.calculateDiscount());   // 2 - 0.2 = 1.8


        //CHECK BUY PAY DISCOUNT
        BuyMorePayLess item04 = new BuyMorePayLess("Milk", 10);
        BuyMorePayLess item05 = new BuyMorePayLess("Milk", 10);
        BuyMorePayLess item06 = new BuyMorePayLess("Milk", 1);
        item04.setBuyPayOffer(3,2);
        item04.calculateDiscount();

        // USERS
        LoyalCustomer customer01 = new LoyalCustomer("Giorgi Tsipuria", "giobaski", "123",
                "Gonsiori 33","55945239");

        //B A S K E T S
        Basket basket01 = new Basket("Tartu 46", "Kairi", customer01);
        basket01.insertItem(item1); //200 -> 200
        basket01.insertItem(item2); // 2.0 -> 1.8
        System.out.println("Total payment in basket: " + basket01.caclulatePayment()); //201.8 + 201.8 * 0.1 = 221.98





        //1. Create Store
        Store store = new Store("Raua 16");

        //2. sign into store
        Cashier currentCashier = store.cashierAuthentication();

        //3.
        Menu currentMenu = store.openMenu();

        //4. new basket
        currentMenu.openNewBasket(customer01);


        //5.Cashier starts adding items into new basket
        System.out.println(currentMenu.getBasket());
        currentMenu.getBasket().insertItem(item1);
        currentMenu.getBasket().insertItem(item2);


        System.out.println("######Basket By ID:");
        currentMenu.printBasketInfoById(2);
        System.out.println("########");


        //6. Calculate total price for the current basket
        currentMenu.getBasket().caclulatePayment();
        System.out.println(currentMenu.getBasket());
        System.out.println("currents items: ");
        System.out.println(currentMenu.getBasket().getItems());

        //7. Logout cashier
        Thread.sleep(10000);
        currentMenu.exit();


        // Additional features
        System.out.println("points of the loyal customer: " + customer01.getPoints());

        System.out.println("Bonus for cashier: " + currentCashier.calculateBonus() + " Euros");






    }

}
