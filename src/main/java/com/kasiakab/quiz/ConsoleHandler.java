package com.kasiakab.quiz;

import java.util.Scanner;

public class ConsoleHandler {

    private Scanner scanner = new Scanner(System.in);


    public void displayQuestion(String question) {
        System.out.println(question);
    }

    public String getUserAnswer() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public void showResult(int score, int total) {
        System.out.println("Your result is " + score + "/" + total + ".");
    }

    public void close() {
        scanner.close();
    }
}
