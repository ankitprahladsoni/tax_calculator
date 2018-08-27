package com.taxcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.taxcalculator.domain.builder.ItemBuilder;
import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.receipt.Receipt;
import com.taxcalculator.util.StringUtils;

/**
 * Main class of Tax Calculator Application
 *
 * @author ankit
 */
class TaxCalculatorApplication {

    /**
     * Generates Receipt from the given products list
     *
     * @param inputs
     * @return {@link Receipt}
     */
    Receipt generateReceipt(String[] inputs) {

        List<Item> items = generateItemData(inputs);
        return new Receipt(items);
    }

    private List<Item> generateItemData(String[] inputs) {
        List<Map<String, String>> itemsData = generateItemsData(inputs);
        return ItemBuilder.convertToItems(itemsData);
    }

    private List<Map<String, String>> generateItemsData(String[] inputs) {
        return Arrays.stream(inputs).map(StringUtils::separateData).collect(Collectors.toList());
    }
}
