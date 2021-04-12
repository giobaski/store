package com.company.users;

public class EmployeeCustomer extends User {
    private int points;
    private int bonus;

    public EmployeeCustomer(String name_surname, String username, String password, String address, String phoneNumber) {
        super(name_surname, username, password, address, phoneNumber);
    }

//    Employee as a customer: The customer gets a bonus for every basket corresponding to the
//    type of customer. For 100 bonus points, they get a bonus in their salary of 50 Euro.

    public void calculateBonus(){
        if(this.points> 100)
            this.bonus = this.points/100 * 50;
    }

    public void printInfo(){
        System.out.println("EmployeeCustomer");
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
