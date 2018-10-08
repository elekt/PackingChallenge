package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemModel;

public class ItemParser {

    public ItemModel parseItem(String itemString) throws APIException {
        String[] itemValues = itemString.replaceAll("[()€]","").split(",");
        int index = Integer.parseInt(itemValues[0]);
        double weight = Double.parseDouble(itemValues[1]);
        int cost = Integer.parseInt(itemValues[2]);

        return new ItemModel(index, weight, cost);
    }
}
