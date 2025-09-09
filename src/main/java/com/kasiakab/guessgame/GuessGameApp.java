package com.kasiakab.guessgame;


public class GuessGameApp {

    private static boolean keepPlaying = true;

    public static void run() {
        while (true) {
            GameLogic.play();

            Character response = ConsoleReader.askPlayAgain();

            if (!response.equals('Y')) {
                ConsoleReader.goodbyeMessage();
                keepPlaying = false;
                break;
            } else {
                keepPlaying = true;
            }
        }
    }
}
