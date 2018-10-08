package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PackageParser {

    public PackageModel parsePackage(String packageString) throws APIException {
        ItemParser itemParser = new ItemParser();
        List<ItemModel> items = new ArrayList<>();
        String[] splittedPackage = packageString.split(":");
        Double maxWeight = Double.parseDouble(splittedPackage[0].trim());

        try (Stream<String> stream = Arrays.stream(splittedPackage[1].trim().split(" "))) {
            stream.forEach(line -> items.add(itemParser.parseItem(line)));
        }

        return new PackageModel(maxWeight.intValue(), items);
    }
}
