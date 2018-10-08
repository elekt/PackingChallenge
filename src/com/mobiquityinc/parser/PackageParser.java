package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Parses a package from a string.
 * example form:
 * 56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79)
 * @author Tamas Elekes
 */
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
