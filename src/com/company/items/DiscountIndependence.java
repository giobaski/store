package com.company.items;

public class DiscountIndependence extends ItemWithDiscount {
    private double amountOfDiscountIndependence;

    //Constructor
    public DiscountIndependence(String name, double price) {
        super(name, price);
    }

    public void setAmountOfDiscountIndependence(double amountOfDiscountIndependence) {
        this.amountOfDiscountIndependence = amountOfDiscountIndependence;
        this.setDiscount(this.getDiscount() + amountOfDiscountIndependence);
    }

    public double calculateDiscount(){
//        System.out.println("func" + super.getPrice() * (1-super.getDiscount()));
//        return super.getPrice() * (1-super.getDiscount());
        return this.getPrice() - (this.getPrice() * this.getDiscount())/100;
    }
}
