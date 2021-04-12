package com.company;

import com.company.baskets.Basket;
import com.company.users.Cashier;
import com.company.users.User;


public class Menu {
    private Basket basket;
    private Cashier cashier;
    private String storeAddress;
    private String language; //TODO: get language from system

    public Menu(String storeAddress, Cashier cashier) {
        this.cashier = cashier;
        this.storeAddress = storeAddress;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket openNewBasket(User user){
        //TODO:save all basket into this.baskets list
        this.basket = new Basket(this.storeAddress, this.cashier.getName_surname(), user);
        Store.currentBaskets.add(this.basket);
        return this.basket;
    }


    //Print information for basket with a certain ID
    public void printBasketInfoById (int id){
        Store.getCurrentBaskets().stream()
                .filter(x -> x.getId()==id)
                .forEach(System.out::println);
    }


    public void exit(){
        this.cashier.logout();
        Store.servedBaskets.add(this.basket);
        //TODO: save existing arraylist and exit, destroy object
    }

    @Override
    public String toString() {
        return "Menu{" +
                "basket=" + basket +
                '}';
    }
}
