package com.taxcalculator.domain.entities;

import com.taxcalculator.util.MathUtils;

import java.util.stream.Stream;

/**
 * Domain class to hold Item values
 *
 * @author ankit
 */
public class Item {

    private String name;
    private int quantity;
    private boolean isImported;
    private boolean isExempted;
    private double basePrice;

     public Item(String quantity, String name, String basePrice) {
        this.name = name;
        this.quantity = Integer.valueOf(quantity);
        this.basePrice = Double.valueOf(basePrice);
        this.isImported = isImported();
        this.isExempted = isExempted();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFinalPrice() {
        double totalTaxAmount = getTaxAmount();
        return MathUtils.roundOffAmount(quantity * basePrice + totalTaxAmount);
    }

    public double getTaxAmount() {
        double basicSalesTaxAmount = getBasicSalesTaxAmount();
        double additionalSalesTaxAmount = getAdditionalSalesTaxAmount();

        return MathUtils.roundOffTax(quantity * (basicSalesTaxAmount + additionalSalesTaxAmount));
    }

    private double getAdditionalSalesTaxAmount() {
        double additionalSalesTax = isImported ? 0.05 : 0;
        return basePrice * additionalSalesTax;
    }

    private double getBasicSalesTaxAmount() {
        double basicSalesTax = isExempted ? 0 : 0.1;
        return basePrice * basicSalesTax;
    }

    private boolean isImported() {
        return this.name.contains("imported");
    }

    private boolean isExempted() {
        return Stream.of("book", "chocolate", "pill")
                .anyMatch(exemptedItem -> this.name.contains(exemptedItem));
    }

}
