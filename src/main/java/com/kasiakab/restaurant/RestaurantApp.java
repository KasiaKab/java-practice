package com.kasiakab.restaurant;


public class RestaurantApp {


    private ConsoleHandler console = new ConsoleHandler();
    private Order order = null;


    public void run() {
        console.showMessage("=== Welcome to the Restaurant ===");
        console.showMessage("Today's menu:");
        MenuService.getMenu();


    }
}
