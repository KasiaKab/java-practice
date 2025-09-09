package com.kasiakab.guessgame;

import java.util.Random;

public class GameLogic {

    private GameLogic() {
        // Klasa narzędziowa (utility class) — zawiera tylko metody statyczne.
        // Tworzenie instancji nie ma sensu i jest zablokowane.
    }

    private static final int MAX_ATTEMPTS = 5;

    private static Random rand = new Random();

    public static void play() {
        ConsoleReader.welcomeMessage();

        int secretNumber = rand.nextInt(101);
        int counter = 0;

        while (counter < MAX_ATTEMPTS) {
            int inputNumber = ConsoleReader.collectNumber();
            counter++;

            if (inputNumber < secretNumber) {
                ConsoleReader.toLowMessage(counter);
            } else if (inputNumber > secretNumber) {
                ConsoleReader.toHighMessage(counter);
            } else {
                ConsoleReader.winMessage();
                break;
            }
        }
        if (counter == MAX_ATTEMPTS)
            ConsoleReader.gameOverMessage(secretNumber);

    }
}
