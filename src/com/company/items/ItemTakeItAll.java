package com.company.items;

public class ItemTakeItAll extends ItemWithDiscount{
    public ItemTakeItAll(String name, double price) {
        super(name, price);
    }
}
//
//    So called ItemTakeItAll, which has an additional feature more than ItemWithDiscount
//        which is N, the minimum number of items to be purchased. (Ex. N=5 or N=10) with the
//        lowered price. The number N should be defined by the manager.
