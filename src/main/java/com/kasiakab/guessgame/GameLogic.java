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
        ConsoleReader.welcomeMessage();

        int secretNumber = rand.nextInt(101);
        int counter = 0;

        while (counter < MAX_ATTEMPTS) {
            int inputNumber = ConsoleReader.collectNumber();
            counter++;
            int difference = Math.abs(inputNumber - secretNumber);

            if (inputNumber < secretNumber) {
                if (difference <= CLOSE_RANGE) {
                    ConsoleReader.toLowCloseMessage(counter);
                } else {
                    ConsoleReader.toLowMessage(counter);
                }
            } else if (inputNumber > secretNumber) {
                if (difference <= CLOSE_RANGE) {
                    ConsoleReader.toHighCloseMessage(counter);
                } else {
                    ConsoleReader.toHighMessage(counter);
                }
            } else {
                ConsoleReader.winMessage();
                break;
            }
        }
        if (counter == MAX_ATTEMPTS)
            ConsoleReader.gameOverMessage(secretNumber);

    }
}
