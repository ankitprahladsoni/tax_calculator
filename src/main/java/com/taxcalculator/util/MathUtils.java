package com.taxcalculator.util;

public class MathUtils {

    public static double roundOffTax(double number) {
        return roundOff(number, 20);
    }

    public static double roundOffAmount(double number) {
        return roundOff(number, 100.0);
    }

    private static double roundOff(double number, double factor) {
        return Math.round(number * factor) / factor;
    }

}
