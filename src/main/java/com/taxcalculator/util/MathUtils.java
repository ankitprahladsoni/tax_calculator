package com.taxcalculator.util;

public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static double roundOffTax(double number) {
        return Math.ceil(number * 20) / 20;
    }

    public static double roundOffAmount(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
