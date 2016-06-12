package com.taxcalculator.receipt;

import java.util.List;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.util.MathUtils;

public class Receipt {

	private String itemDescription;
	private double totalSalesTax = 0.0;
	private double totalAmount = 0.0;

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public Receipt(List<Item> items) {
		StringBuilder itemDetails = new StringBuilder();
		items.forEach(item -> {
			itemDetails.append(item.getQuantity()).append(" ").append(item.getName()).append(" : ")
					.append(item.getFinalPrice()).append("\n");
			totalSalesTax += item.getTaxAmount();
			totalAmount += item.getFinalPrice();
		});

		itemDescription = itemDetails.toString();
		totalSalesTax = MathUtils.roundOffTax(totalSalesTax);
	}

	@Override
	public String toString() {
		return "\n\n" + "Receipt \n" + itemDescription + "Sales Taxes: " + totalSalesTax + "\nTotal: " + totalAmount;
	}

}
