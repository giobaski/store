package com.company.baskets;

import com.company.Store;
import com.company.interfaces.Payable;
import com.company.items.Item;
import com.company.users.EmployeeCustomer;
import com.company.users.LoyalCustomer;
import com.company.users.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Basket implements Payable {
    private int id;
    private double netAmount;
    private double totalAmount;
    private double VAT = 0.1;           //TODO:modify this using VatAmount and VatRate
    ArrayList<Item> items;
    private LocalDateTime purchaseDateTime;  //TODO: define it into calculatePayment()
    private String storeAddress;
    private String nameOfCashier;
    private User user;

    private static int nextNumber;

    public Basket(String storeAddress, String nameOfCashier, User user) {
        this.id = ++nextNumber;
        this.items = new ArrayList<>();
        this.storeAddress = storeAddress;
        this.nameOfCashier = nameOfCashier;
        this.user = user;
    }

    public void insertItem(Item item) throws InterruptedException {
        items.add(item);
        System.out.println(item.getName() + " -->>> " + " has been added into current basket");
//        System.out.println(item.getName() + " -->>> " + Store.bundle.getString("addItemText")); //addItemText="has been added into current basket"
        Thread.sleep(1000);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public double caclulatePayment() {
        totalAmount = items.stream()
                .mapToDouble(Item::calculateDiscount)
                .sum();
        netAmount = totalAmount + totalAmount * VAT;
//        . Basket for loyal customers, for old customers, with an additional feature which is the
//        accumulation of points for the customer. 5 Euro count for 1 point bonus.
        if (this.user instanceof LoyalCustomer){
            int point = (int)totalAmount / 5;
            ((LoyalCustomer) this.user).setPoints(point);
        } else if (this.user instanceof EmployeeCustomer){
            //15 Euro count for a bonus of 1 point.
            int point = (int)totalAmount / 15;
            ((EmployeeCustomer) this.user).setPoints(point);
        }
        return netAmount;
    }




    //Apply discount to basket with 10% for Christmas promotion
    public void applyChristmasDiscount(){
        this.totalAmount = this.totalAmount * 0.9;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", netAmount=" + netAmount +
                ", totalAmount=" + totalAmount +
                ", VAT=" + VAT +
                ", items=" + items +
                ", purchaseDateTime=" + purchaseDateTime +
                ", storeAddress='" + storeAddress + '\'' +
                ", nameOfCashier='" + nameOfCashier + '\'' +
                '}';
    }
}
