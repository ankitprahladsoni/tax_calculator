package com.taxcalculator.domain.entities;

import com.taxcalculator.util.MathUtils;

import java.util.stream.Stream;

public class Item {

    private String name;
    private int quantity;
    private double basePrice;
    private double basicSalesTaxAmount;
    private double additionalSalesTaxAmount;

    public Item(String quantity, String name, String basePrice) {
        this.name = name;
        this.quantity = Integer.valueOf(quantity);
        this.basePrice = Double.valueOf(basePrice);
    }

    public double getFinalPrice() {
        return MathUtils.roundOffAmount(quantity * basePrice + getTaxAmount());
    }

    public double getTaxAmount() {
        return quantity * (basicSalesTaxAmount + additionalSalesTaxAmount);
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isExempted() {
        return Stream.of("book", "chocolate", "pill")
                .anyMatch(exemptedItem -> name.contains(exemptedItem));
    }

    public void setBasicSalesTaxAmount(double factor) {
        basicSalesTaxAmount = basePrice * factor;
    }

    public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
        additionalSalesTaxAmount = MathUtils.roundOffTax(basePrice * additionalSalesTaxPercent);
    }

    public String toString() {
        return String.valueOf(quantity) +
                " " +
                name +
                " : " +
                getFinalPrice();
    }
}
