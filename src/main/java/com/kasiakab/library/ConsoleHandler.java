package com.kasiakab.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleHandler {

    private final static Scanner sc = new Scanner(System.in);


    public void displayOption() {
        for (ConsoleOption option : ConsoleOption.values()) {
            System.out.println((option.ordinal() + 1) + " - " + option.getDescription());
        }
    }

    public ConsoleOption readOption() {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option < 1 || option > ConsoleOption.values().length) {
                    showMessage("Please enter a number between 1 and " + ConsoleOption.values().length + ".");
                    displayOption();
                    continue;
                }
                return ConsoleOption.values()[option - 1];
            } catch (InputMismatchException ex) {
                showMessage("Invalid input. Please enter a numeric value.");
                sc.nextLine();
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readString() {
        return sc.nextLine();
    }
}

