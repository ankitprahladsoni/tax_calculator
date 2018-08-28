package com.taxcalculator.domain.factory;

import com.taxcalculator.domain.ItemAdapter;
import com.taxcalculator.domain.ItemTaxCalculator;
import com.taxcalculator.domain.entities.Item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemFactory {

    public static List<Item> from(String[] inputs) {
        return Arrays.stream(inputs)
                .map(ItemFactory::from)
                .collect(Collectors.toList());
    }

    private static Item from(String input) {
        Item item = ItemAdapter.createItemFromString(input);
        ItemTaxCalculator.applyTaxes(item);
        return item;
    }

}
