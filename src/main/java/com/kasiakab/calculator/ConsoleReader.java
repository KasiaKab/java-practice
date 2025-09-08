package com.kasiakab.calculator;

import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner sc = new Scanner(System.in);

    public double getFirstNumber() {
        System.out.println("Please enter first number: ");
        double a = sc.nextDouble();
        sc.nextLine();
        return a;
    }

    public char getOperator() {
        System.out.println("Please enter operator: ");
        char operator = sc.next().charAt(0);
        CalculatorValidator.validateOperator(operator);
        return operator;
    }

    public double getSecondNumber() {
        System.out.println("Please enter second number: ");
        double b = sc.nextDouble();
        sc.nextLine();
        return b;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }


}
