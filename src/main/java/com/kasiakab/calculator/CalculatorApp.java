package com.kasiakab.calculator;

public class CalculatorApp {

    private static final ConsoleReader reader = new ConsoleReader();
    private static final CalculatorService service = new CalculatorService();

    public static void run() {
        double a = reader.getFirstNumber();
        char op = reader.getOperator();
        double b = reader.getSecondNumber();

        double result = service.calculate(a, op, b);
        reader.printResult(result);
    }
}
