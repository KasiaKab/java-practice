package com.kasiakab.restaurant;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleHandler {

    private final Scanner sc = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void displayOption() {
        for (RestaurantOption option : RestaurantOption.values()) {
            System.out.println((option.ordinal() + 1) + " - " + option.getDescription());
        }
    }

    public RestaurantOption readOption() {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option < 1 || option > RestaurantOption.values().length) {
                    showMessage("Please enter a number between 1 and " + (RestaurantOption.values().length - 1) + ".");
                    displayOption();
                    continue;
                }
                return RestaurantOption.values()[option - 1];
            } catch (InputMismatchException ex) {
                showMessage("Invalid input. Please enter a numeric value.");
                sc.nextLine(); // wyczyszczenie niepoprawnego wejścia
            }
        }
    }

    public Order readOrder(List<Dish> menu) {
        while (true) {
            showMessage("Order the selected dishes, listing their numbers separated by commas:");

            String input = sc.nextLine();
            Order order = new Order();
            boolean isValid = false;

            try {
                String[] parts = input.split(",");

                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    int index = number - 1;

                    if (index < 0 || index >= menu.size()) {
                        showMessage("Error: Dish number " + number + " is not available. Please choose from 1 to " + menu.size() + ".");
                        isValid = false;
                        break;
                    }
                    Dish dish = menu.get(index);
                    order.addDish(dish);
                }

                if (isValid) {
                    return order;
                }
            } catch (NumberFormatException ex) {
                showMessage("Invalid input. Please enter a numeric value.");
            }
        }
    }


    public void displayMenu(List<Dish> menu) {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).toString());

        }
    }
}
