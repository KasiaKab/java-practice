package com.kasiakab.restaurant;

import java.util.List;

public class MenuService {

    public static List<Dish> getMenu() {
        return List.of(
                new Dish("Margherita Pizza", 8.99),
                new Dish("Pepperoni Pizza", 10.49),
                new Dish("Spaghetti Bolognese", 12.75),
                new Dish("Caesar Salad", 7.50),
                new Dish("Grilled Chicken Sandwich", 9.25),
                new Dish("Beef Burger", 11.30),
                new Dish("Fish and Chips", 13.40),
                new Dish("Mushroom Risotto", 12.20),
                new Dish("Tomato Soup", 6.80),
                new Dish("Cheesecake Slice", 5.95)
        );
    }
}
