package com.pjatk.control;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BmiCalculatorTest {

    private final BmiCalculator bmiCalculator = new BmiCalculator();

    @Test
    public void shouldCalculateBmi() {
        double bodyMass = 100.0;
        double height = 2.0;
        assertEquals(25.0, bmiCalculator.calculate(bodyMass, height), 0.01);
    }
}