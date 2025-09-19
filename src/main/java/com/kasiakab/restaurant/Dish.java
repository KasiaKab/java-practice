package com.kasiakab.restaurant;

public class Dish {

    private String positionName;
    private double price;

    public Dish(String positionName, double price) {
        this.positionName = positionName;
        this.price = price;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return positionName + ", " + price + "zł";
    }

}