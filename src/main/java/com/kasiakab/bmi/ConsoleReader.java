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

    public void displayResult(double result, String category) {
        System.out.printf("BMI Result: %.2f%nCategory: %s%n", result, category);
    }

    public char wantToContinue() {
        System.out.println("------------\nWant to Continue? (Y/N):");
        return scanner.next().trim().toUpperCase().charAt(0);
    }

    public void byeMessage() {
        System.out.println("Bye! Bye!");
    }
}
