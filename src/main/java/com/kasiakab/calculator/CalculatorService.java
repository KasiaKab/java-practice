package com.kasiakab.calculator;

public class CalculatorService {

    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                return a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }

    }

}

