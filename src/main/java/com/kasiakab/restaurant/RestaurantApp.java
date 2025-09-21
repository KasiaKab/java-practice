package com.kasiakab.restaurant;

import java.util.List;

public class RestaurantApp {


    private ConsoleHandler console = new ConsoleHandler();
    private PaymentService paymentService = new PaymentService();


    public void run() {
        console.showMessage("=== Welcome to the Restaurant ===");
        console.displayOption();
        RestaurantOption choice = console.readOption();

        switch (choice) {
            case ORDER -> {

                //1. Pokaż menu
                console.showMessage("Today's menu:");
                List<Dish> menu = MenuService.getMenu();
                console.displayMenu(menu);

                //2. Przeczytaj zamówienie
                Order order = console.readOrder(menu);

                //3. Oblicz i pokaż płatność
                countPayment(order);
            }
            case EXIT -> {
                console.showMessage("Goodbye!");
                System.exit(0);
            }
            default -> console.showMessage("Invalid option. Try again.");
        }
    }


    private void countPayment(Order order) {
        double total = paymentService.totalPrice(order);
        double tip = paymentService.countTip(total);

        console.showMessage("=== Your Order ===");
        for (Dish dish : order.getOrder()) {
            console.showMessage(" - " + dish);
        }

        console.showMessage("\nSubtotal: " + String.format("%.2f", total) + " zł");
        console.showMessage("Service charge (15%): " + String.format("%.2f", tip - total) + " zł");
        console.showMessage("Total to pay: " + String.format("%.2f", tip) + " zł");

    }
}
