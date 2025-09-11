package com.kasiakab.todolist;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleReader {

    private ConsoleReader() {
    };

    private static Scanner sc = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Welcome to your to-do list!");
    }

    public static void displayMenu() {
        System.out.println("Please choose one of the following options:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println((option.ordinal() + 1) + " - " + option.getDescription());
        }
    }

    public static String readString(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    public static int readInt(String message) {
        while (true) {
            /*dopóki użytkownik nie poda poprawnej liczby*/
            try {
                System.out.println(message);
                int taskNumber = sc.nextInt();
                sc.nextLine();
                return taskNumber;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    public static void showSuccess(String message) {
        System.out.println(message);
    }

    public static void showError(String message) {
        System.out.println(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        System.out.println();
    }

    public static void close() {
        sc.close();
    }

}
