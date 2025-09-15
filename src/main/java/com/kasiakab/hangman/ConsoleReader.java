package com.kasiakab.hangman;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner sc = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() {
        return sc.nextLine().trim().toLowerCase();
    }

}
