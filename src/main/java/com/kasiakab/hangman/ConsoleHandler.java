package com.kasiakab.hangman;

import java.util.Scanner;

public class ConsoleHandler {

    private Scanner sc = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() {
        return sc.nextLine().trim().toLowerCase();
    }

    public void displayGameOptions() {
        for (GameOption gameOption : GameOption.values()) {
            System.out.println((gameOption.ordinal() + 1) + ". " + gameOption.getDescription());
        }
    }

}
