package com.kasiakab.restaurant;

public class PaymentService {

    public double totalPrice(Order order) {
        double total = 0.0;
        for (Dish dish : order.getOrder()) {
            total += dish.getPrice();
        }

        return total;

    }

    public static double countTip(double total) {
        double tip;
        if (total < 100.0) {
            tip = total * 0.15;
        } else {
            tip = total * 0.10;
        }
        return total + tip;
    }
}