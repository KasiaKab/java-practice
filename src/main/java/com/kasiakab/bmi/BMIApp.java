package com.kasiakab.bmi;

public class BMIApp {

    private ConsoleReader reader;
    private BMICalculator calculator;

    public BMIApp() {
        this.reader = new ConsoleReader();
        this.calculator = new BMICalculator();
    }

    private boolean keepCalculating = true;

    public void run() {

        reader.welcomeMessage();

        while (true) {
            double weight = reader.readDouble("Enter your weight in kilograms: ");
            if (weight <= 0) {
                System.out.println("Weight must be greater than 0. Try again.");
                continue; /*wróć na początek pętli — nie idź dalej*/
            }
            double height = reader.readDouble("Enter your height in centimeters: ");
            if (height <= 0) {
                System.out.println("Height must be greater than 0. Try again.");
                continue;
            }
            height = height / 100.0;

            double result = calculator.calculateBMI(weight, height);
            String category = calculator.printCategory(result);
            reader.displayResult(result, category);

            char response = reader.wantToContinue();
            if (response != 'Y') {
                keepCalculating = false;
                reader.byeMessage();
                break;
            } else {
                keepCalculating = true;
            }

        }
    }
}
