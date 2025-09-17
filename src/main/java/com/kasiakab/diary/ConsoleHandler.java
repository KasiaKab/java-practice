package com.kasiakab.diary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleHandler {

    public ConsoleHandler() {};

    private final Scanner sc = new Scanner(System.in);

    /*welcome -> choose an option - post added/removed.. -> bye, bye*/
    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() {
        return sc.nextLine();
    }

    public void displayMenu() {
        showMessage("Choose an option:");
        for (MenuOptions option : MenuOptions.values()) {
            System.out.println((option.ordinal() + 1) + " - " + option.getDescription());
        }
    }

    public MenuOptions readMenuOption() {
        while (true) {
            try {
                int option = sc.nextInt();
                sc.nextLine();
                if (option < 1 || option > MenuOptions.values().length) {
                    showMessage("Please enter a number between 1 and " + MenuOptions.values().length + ".");
                    continue;
                }
                return MenuOptions.values()[option - 1];
            } catch (InputMismatchException ex) {
                showMessage("Invalid input. Please enter a numeric value.");
                sc.nextLine(); // wyczyszczenie niepoprawnego wejścia
            }
        }
    }

    public void close() {
        sc.close();
    }
}
