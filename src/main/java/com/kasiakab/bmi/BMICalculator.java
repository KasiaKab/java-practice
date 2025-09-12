package com.kasiakab.bmi;

public class BMICalculator {

    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public String printCategory(double bmi) {
        if (bmi < 18.5) return "Niedowaga";
        else if (bmi < 25) return "Norma";
        else if (bmi < 30) return "Nadwaga";
        else return "Otyłość";
    }
}
