package com.taxcalculator;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.domain.factory.ItemFactory;
import com.taxcalculator.receipt.Receipt;

import java.util.List;

class TaxCalculatorApplication {

    Receipt generateReceipt(String[] inputs) {
        List<Item> items = ItemFactory.from(inputs);
        return new Receipt(items);
    }
}
