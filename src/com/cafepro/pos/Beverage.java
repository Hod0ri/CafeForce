package com.cafepro.pos;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

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

    public Map<String, String> InitializeBev() throws IOException {
        BeverageData data = new BeverageData();

        Map<String, String> mapTemp = data.ReadData();;

        Map<String, String> OrderBeverage = mapTemp;
        Set<String> keys = mapTemp.keySet();
        for(String key : keys) {
            OrderBeverage.put(key, "0");
        }

        return OrderBeverage;
    }

    public void InitialOrder() throws IOException {
        Map<String, String> mTemp = InitializeBev();

        Map<String, Integer> OrderMap;

    }

}
