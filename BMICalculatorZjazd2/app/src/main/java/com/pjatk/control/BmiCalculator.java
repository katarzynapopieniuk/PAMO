package com.pjatk.control;

public class BmiCalculator {

    public double calculate(double bodyMass, double height) {
        return bodyMass / (height * height);
    }
}
