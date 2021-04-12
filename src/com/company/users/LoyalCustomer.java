package com.company.users;

public class LoyalCustomer extends User {
    private int points;
    private int bonus;

    public LoyalCustomer(String name_surname, String username, String password, String address, String phoneNumber) {
        super(name_surname, username, password, address, phoneNumber);
    }

    public void calculateBonus(){
        if(this.points> 100)
            this.bonus = this.points/100 * 10;
    }

    public void printInfo(){
        System.out.println("LoyalCustomer");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
