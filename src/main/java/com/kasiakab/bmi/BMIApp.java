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

    public void run() {
        reader.welcomeMessage();
        while (true) {

            Double weight = readWeight();
            if (weight == null) continue; /*wróć na początek pętli — nie idź dalej*/

            Double height = getHeight();
            if (height == null) continue;

            double result = calculator.calculateBMI(weight, height);
            String category = calculator.getCategory(result);

            reader.displayResult(result, category);
            saveResultToFile(weight, height, result, category);

            if (keepGoing()) break;
        }
    }

    private boolean keepGoing() {
        char response = reader.wantToContinue();
        if (response != 'Y') {
            reader.byeMessage();
            return true;
        }
        return false;
    }

    private Double getHeight() {
        double height = reader.readDouble("Enter your height in centimeters: ");
        if (height <= 0) {
            System.out.println("Height must be greater than 0. Try again.");
            return null;
        }
        height = height / 100.0;
        return height;
    }

    private Double readWeight() {
        double weight = reader.readDouble("Enter your weight in kilograms: ");
        if (weight <= 0) {
            System.out.println("Weight must be greater than 0. Try again.");
            return null;
        }
        return weight;
    }

    public void saveResultToFile(double weight, double height, double result, String category) {
        String fileName = ("C:/Users/kasia/Java Learning/my-java-practice/java-practice/src/main/java/com/kasiakab/bmi/bmi_history.txt");
        File file = new File(fileName);

        ensureFileExists(file, fileName);
        writeLineToFile(weight, height, result, category, fileName);
    }

    private void writeLineToFile(double weight, double height, double result, String category, String fileName) {
        try (
                FileWriter fileWriter = new FileWriter(fileName, true);
                var writer = new BufferedWriter(fileWriter)
        ) {
            String formatted = formatResultLine(weight, height, result, category);
            writer.write(formatted);
            System.out.println("Result saved to file.");
        } catch (IOException e) {
            System.out.format("Failed to save into a file %s.", fileName);
        }
    }

    private void ensureFileExists(File file, String fileName) {
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
    }

    private String formatResultLine(double weight, double height, double result, String category) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = String.format(" %s| Weight: %.2f | Height: %.2f | BMI: %.2f | Category: %s%n", LocalDateTime.now().format(dateTimeFormatter), weight, height, result, category);
        return formatted;
    }
}
