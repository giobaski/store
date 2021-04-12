package com.company.items;

public class Item {
    private  int id;
    private String name;
    private double price;
    private static int nextNumber;

    public Item(String name, double price) {
        this.id = ++nextNumber;
        this.name = name;
        this.price = price;
    }

    public double calculateDiscount(){
        return this.price;
    }

    public void printInfo(){
        System.out.println("ITEM'S INFO");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
