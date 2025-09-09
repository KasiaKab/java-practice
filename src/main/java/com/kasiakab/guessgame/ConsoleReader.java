package com.kasiakab.guessgame;

import java.util.Scanner;

public class ConsoleReader {

    private ConsoleReader() {
        // Klasa narzędziowa (utility class) — zawiera tylko metody statyczne.
        // Tworzenie instancji nie ma sensu i jest zablokowane.
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println("Welcome to the guess game!");
    }

    public static int collectNumber() {
        System.out.println("Please enter a number between 0 and 100:");
        return sc.nextInt();
    }

    public static void toLowMessage(int counter) {
        System.out.println("Attempt " + counter + ": Too low! Try a higher number.");
    }

    public static void toHighMessage(int counter) {
        System.out.println("Attempt " + counter + ": Too high! Try a lower number.");
    }

    public static void winMessage() {
        System.out.println("Congratulations! You guessed it!");
    }

    public static void gameOverMessage(int secretNumber) {
        System.out.println("You have reached the maximum number of attempts!" +
                "\nGame over! The secret number was: " + secretNumber);
    }
}
