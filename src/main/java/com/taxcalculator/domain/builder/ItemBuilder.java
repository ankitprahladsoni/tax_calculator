package com.taxcalculator.domain.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.util.MathUtils;
import com.taxcalculator.util.StringUtils;

/**
 * Builds list of {@link Item} from given inputs
 * 
 * @author ankit
 *
 */
public class ItemBuilder {

	/**
	 * Converts itemData map to {@link Item}
	 * 
	 * @param itemsData
	 * @return list of {@link Item}
	 */
	public static List<Item> convertToItems(List<Map<String, String>> itemsData) {
		List<Item> items = new ArrayList<>();
		for (Map<String, String> itemData : itemsData) {
			Item item = convertToItem(itemData);
			items.add(item);
		}
		return items;
	}

	private static Item convertToItem(Map<String, String> itemData) {

		String itemName = getName(itemData);
		int quantity = getQuantity(itemData);
		double basePrice = getBasePrice(itemData);
		boolean isExempted = isExempted(itemName);
		boolean isImported = isImported(itemName);

		Item item = new Item(itemName, quantity, basePrice, isExempted, isImported);
		return item;

	}

	private static boolean isExempted(String itemName) {
		return StringUtils.isExempted(itemName);
	}

	private static boolean isImported(String itemName) {
		return StringUtils.isImported(itemName);
	}

	private static double getBasePrice(Map<String, String> itemData) {
		return MathUtils.getBasePrice(itemData);
	}

	private static int getQuantity(Map<String, String> itemData) {
		return MathUtils.getQuantity(itemData);
	}

	private static String getName(Map<String, String> itemData) {
		return itemData.get(StringUtils.NAME);
	}

}
