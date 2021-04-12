package com.company.items;

public class ItemWithDiscount extends Item{
    public static double discount;

    public ItemWithDiscount(String name, double price) {
        super(name, price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double calculateDiscount(){
        return this.getPrice() - (this.getPrice() * this.discount)/100;
    }
}

