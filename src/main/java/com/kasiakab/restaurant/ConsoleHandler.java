package com.kasiakab.restaurant;

import java.util.ArrayList;
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

    public RestaurantOption readResaturantOption() {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option < 1 || option > RestaurantOption.values().length) {

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



}
