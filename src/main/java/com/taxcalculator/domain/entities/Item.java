package com.taxcalculator.domain.entities;

import com.taxcalculator.util.MathUtils;

/**
 * Domain class to hold Item values
 * 
 * @author ankit
 *
 */
public class Item {

	String name;
	int quantity;
	boolean isImported;
	boolean isExempted;
	double basePrice;

	public Item(String name, int quantity, double basePrice, boolean isExempted, boolean isImported) {
		this.name = name;
		this.quantity = quantity;
		this.basePrice = basePrice;
		this.isExempted = isExempted;
		this.isImported = isImported;
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

}
