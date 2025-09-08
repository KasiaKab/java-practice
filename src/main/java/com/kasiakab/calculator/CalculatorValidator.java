package com.kasiakab.calculator;

public class CalculatorValidator {

    public static void validateOperator(char op) {
        if ("+-*/".indexOf(op) == -1) {
            throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void validateDivisionByZero(char op, double b) {
        if (op == '/' && b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
    }
}
