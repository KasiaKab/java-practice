package com.kasiakab.guessgame;

import java.util.Random;

public class GameLogic {

    private GameLogic() {
        // Klasa narzędziowa (utility class) — zawiera tylko metody statyczne.
        // Tworzenie instancji nie ma sensu i jest zablokowane.
    }

    private static final int MAX_ATTEMPTS = 10;
    private static final int CLOSE_RANGE = 10;

    private static Random rand = new Random();

    public static void play() {
        ConsoleHandler.welcomeMessage();

        int secretNumber = rand.nextInt(101);
        int counter = 0;

        while (counter < MAX_ATTEMPTS) {
            int inputNumber = ConsoleHandler.collectNumber();
            counter++;

            int difference = Math.abs(inputNumber - secretNumber);

            if (checkGuess(inputNumber, secretNumber, difference, counter)) break;
        }
        if (counter == MAX_ATTEMPTS)
            ConsoleHandler.gameOverMessage(secretNumber);

    }

    private static boolean checkGuess(int inputNumber, int secretNumber, int difference, int counter) {
        if (inputNumber < secretNumber) {
            if (difference <= CLOSE_RANGE) {
                ConsoleHandler.toLowCloseMessage(counter);
            } else {
                ConsoleHandler.toLowMessage(counter);
            }
        } else if (inputNumber > secretNumber) {
            if (difference <= CLOSE_RANGE) {
                ConsoleHandler.toHighCloseMessage(counter);
            } else {
                ConsoleHandler.toHighMessage(counter);
            }
        } else {
            ConsoleHandler.winMessage();
            return true;
        }
        return false;
    }
}
