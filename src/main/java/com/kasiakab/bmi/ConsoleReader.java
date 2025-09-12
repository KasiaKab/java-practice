package com.kasiakab.bmi;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner = new Scanner(System.in);

    public ConsoleReader() {};

    public void welcomeMessage() {
        System.out.println("=== Welcome to BMI Calculator ===");
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }

    public void displayResult() {
        System.out.println("BMI Result:");
    }

    public void wantToContinue() {
        System.out.println("Want to Continue?");
    }

    public char readChar() {
        return scanner.next().charAt(0);
    }
}
