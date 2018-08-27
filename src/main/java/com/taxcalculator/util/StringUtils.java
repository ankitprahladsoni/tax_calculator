package com.taxcalculator.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String ITEM_ENTRY_REGEX = "(\\d+) ([\\w\\s]* )at (\\d+.\\d{2})";
    static final String QUANTITY = "quantity";
    public static final String NAME = "name";
    static final String PRICE = "price";

    public static Map<String, String> separateData(String input) {
        Map<String, String> itemData = new HashMap<>();

        Pattern pattern = Pattern.compile(ITEM_ENTRY_REGEX);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {

            itemData.put(QUANTITY, matcher.group(1));
            itemData.put(NAME, matcher.group(2));
            itemData.put(PRICE, matcher.group(3));
        }

        return itemData;
    }

    public static boolean isImported(String itemName) {
        return itemName.contains("imported");
    }

    public static boolean isExempted(String itemName) {
        return itemName.contains("book") || itemName.contains("chocolate") || itemName.contains("pill");
    }

}