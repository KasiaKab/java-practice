package com.kasiakab.restaurant;

public enum RestaurantOption {

    ORDER("Make an order"),
    EXIT("Exit");

    private final String description;

    RestaurantOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
