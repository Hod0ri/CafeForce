package com.cafepro.forcemachine;

public class Beverage {
    private String beverageName;
    private int beveragePrice;
    protected int orderCount = 0;

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public int getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(int beveragePrice) {
        this.beveragePrice = beveragePrice;
    }
}
