package com.kasiakab.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Dish> order;

    public Order() {
        this.order = new ArrayList<>();
    }

    public List<Dish> getOrder() {
        return order;
    }
}
