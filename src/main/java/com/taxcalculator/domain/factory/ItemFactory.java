package com.taxcalculator.domain.factory;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ItemFactory {

    public static List<Item> from(String[] inputs) {
        return Arrays.stream(inputs)
                .map(ItemFactory::from)
                .collect(Collectors.toList());
    }

    private static Item from(String input) {
        Pattern pattern = Pattern.compile(StringUtils.ITEM_ENTRY_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        return new Item(matcher.group(1), matcher.group(2), matcher.group(3));
    }

}
