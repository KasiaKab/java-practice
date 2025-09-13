package com.kasiakab.bmi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            saveResultToFile(weight, height, result, category);

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

    public void saveResultToFile(double weight, double height, double result, String category) {
        String fileName = ("C:/Users/kasia/Java Learning/my-java-practice/java-practice/src/main/java/com/kasiakab/bmi/bmi_history.txt");
        File file = new File(fileName);

        boolean fileExists = file.exists();

        /*jeżeli nieprawdą jest, że plik istnieje, to chcemy go utworzyć*/
        if (!fileExists) {
            try {
                /*metoda, która próbuje utworzyć nowy plik, zwraca boolean*/
                fileExists = file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Failed to create a file.");
            }
        }
        if (fileExists) {
            System.out.format("File %s already exists.", fileName);
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            var writer = new BufferedWriter(fileWriter);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formated = String.format
                    (" %s| Weight: %.2f | Height: %.2f | BMI: %.2f | Category: %s%n",
                            LocalDateTime.now().format(dateTimeFormatter),
                            weight,
                            height,
                            result,
                            category);
            writer.write(formated);
            writer.close();
        } catch (IOException e) {
            System.out.format("Failed to save into a file %s.", fileName);
        }

    }
}
