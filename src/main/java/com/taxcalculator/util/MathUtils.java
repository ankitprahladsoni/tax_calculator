package com.taxcalculator.util;

import java.util.Map;

public class MathUtils {

	public static double roundOffTax(double number) {
		return Math.round(number * 20.0) / 20.0;
	}

	public static double roundOffAmount(double number) {
		return Math.round(number * 100.0) / 100.0;
	}

	public static int getQuantity(Map<String, String> itemData) {
		return Integer.parseInt(itemData.get(StringUtils.QUANTITY));
	}

	public static double getBasePrice(Map<String, String> itemData) {
		return Double.parseDouble(itemData.get(StringUtils.PRICE));
	}

}
