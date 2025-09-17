package com.kasiakab.guessgame;


public class GuessGameApp {

    private static boolean keepPlaying = true;

    public static void run() {
        while (true) {
            GameLogic.play();

            Character response = ConsoleHandler.askPlayAgain();

            if (!response.equals('Y')) {
                ConsoleHandler.goodbyeMessage();
                keepPlaying = false;
                break;
            } else {
                keepPlaying = true;
            }
        }
    }
}
