package com.company.items;

/**
  *    So called ItemTakeItAll, which has an additional feature more than ItemWithDiscount
  *    which is N, the minimum number of items to be purchased. (Ex. N=5 or N=10) with the
  *    lowered price. The number N should be defined by the manager.
 */
public class ItemTakeItAll extends ItemWithDiscount{
    private int minimumNumber;
    public static int numberOfCreatedInstance;       // amount of objects created in a basket //
    private static int nextNumber;


    public ItemTakeItAll(String name, double price) {
        super(name, price);
        numberOfCreatedInstance = ++nextNumber;
    }


    public int getMinimumNumber() {
        return minimumNumber;
    }

    public void setMinimumNumber(int minimumNumber) {
        this.minimumNumber = minimumNumber;
    }


    public double calculateDiscount(){
        if(minimumNumber !=0 && numberOfCreatedInstance > minimumNumber){
            return this.getPrice() - (this.getPrice() * this.discount)/100;
        }else{
            return this.getPrice();
        }
    }


}


