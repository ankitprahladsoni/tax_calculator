package com.taxcalculator;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.domain.factory.ItemFactory;
import com.taxcalculator.receipt.Receipt;

import java.util.List;

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

        List<Item> items = ItemFactory.from(inputs);
        return new Receipt(items);
    }
}
