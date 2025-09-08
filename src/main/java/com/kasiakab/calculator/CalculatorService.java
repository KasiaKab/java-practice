package com.kasiakab.calculator;

public class CalculatorService {

    public double calculate(double a, char operator, double b) {

        CalculatorValidator.validateDivisionByZero(operator, b);

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

