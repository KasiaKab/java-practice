package com.kasiakab.guessgame;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {


    private static final int MAX_ATTEMPTS = 5;

    private static final Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();


    public static void play() {
        System.out.println("Welcome to the guess game!"
                + "\nPlease enter a number between 0 and 100");

        int secretNumber = rand.nextInt(101);
        int counter = 0;

        while (counter < MAX_ATTEMPTS) {
            System.out.println("Please enter a number between 0 and 100");
            int inputNumber = scanner.nextInt();
            counter++;

            if (inputNumber < secretNumber) {
                System.out.println("Attempt: " + counter + "Too low! Try a higher number.");
            } else if (inputNumber > secretNumber) {
                System.out.println("Attempt: " + counter + "Too high! Try a lower number.");
            } else {
                System.out.println("Congratulations! You guessed it!");
                break;
            }
        }
        if (counter == MAX_ATTEMPTS)
            System.out.println("You have reached the maximum number of attempts!" +
                    "\nGame over! The secret number was: " + secretNumber);

    }
}
