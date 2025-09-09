package com.kasiakab.guessgame;

import java.util.InputMismatchException;
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
        while (true) {
            // wykonuj, DOPÓKI WARUNEK == true

            System.out.println("Please enter a number between 0 and 100:");
            try {
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("That's not a number! Try again.");
                sc.nextLine();
            }
        }
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

    public static Character askPlayAgain() {
        System.out.println("----------------- \nPlay again? (Y/N):");
        return sc.next().charAt(0);
    }

    public static void goodbyeMessage() {
        System.out.println("Thanks for playing! See you next time!");
    }
}
