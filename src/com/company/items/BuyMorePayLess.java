package com.company.items;

import java.util.HashMap;

public class BuyMorePayLess extends Item {
    public static int numberOfCreatedInstance;       // amount of objects created in a basket //
    HashMap<Integer, Integer> buyPayMapping;
    private static int nextNumber;

    //constructor
    public BuyMorePayLess(String name, double price) {
        super(name, price);
        this.buyPayMapping = new HashMap<>();
        numberOfCreatedInstance = ++nextNumber;         //TODO:"The maximum that one customer can buy of this item is 10 items"

    }

    //Offer defined by manager
    public void setBuyPayOffer(int buyAmount, int payAmount){
        this.buyPayMapping.put(buyAmount, payAmount);
    }

    //For example: if price is 10$ and offer is "If you buy 3 you pay 2", new price should be 10*2/3 = 6.666666666666667$)
    public double calculateDiscount(){
        Integer pay = buyPayMapping.get(numberOfCreatedInstance);
//        System.out.println("Number of Instances: " + numberOfCreatedObjects);  //TODO:Delete this line
        if (pay != null){
            Integer buy = numberOfCreatedInstance;
            double newPrice = this.getPrice() *  pay / buy;
//            System.out.println("New Price: " + newPrice);                       //TODO:Delete this line
            return newPrice;
        } else{
            return this.getPrice();
        }
    }

}
