package com.taxcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.taxcalculator.domain.builder.ItemBuilder;
import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.receipt.Receipt;
import com.taxcalculator.util.StringUtils;

/**
 * Main class of Tax Calculator Application
 * 
 * @author ankit
 *
 */
public class TaxCalculatorApplication {

	/**
	 * Generates Receipt from the given products list
	 * 
	 * @param inputs
	 * @return {@link Receipt}
	 */
	public Receipt generateReceipt(String[] inputs) {

		List<Item> items = generateItemData(inputs);
		return new Receipt(items);
	}

	private List<Item> generateItemData(String[] inputs) {
		List<Map<String, String>> itemsData = generateItemsData(inputs);
		List<Item> items = ItemBuilder.convertToItems(itemsData);
		return items;
	}

	private List<Map<String, String>> generateItemsData(String[] inputs) {
		List<Map<String, String>> itemsData = new ArrayList<>();

		for (String input : inputs) {
			Map<String, String> itemData = StringUtils.separateData(input);
			itemsData.add(itemData);
		}

		return itemsData;
	}
}
