package com.mobiquityinc.test;

import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;
import com.mobiquityinc.parser.PackageParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageParserTest {

    @Test
    void testParsePackage() {
        PackageParser packageParser = new PackageParser();

        PackageModel testPackage = packageParser.parsePackage("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3)");

        List<ItemModel> testItems = Arrays.asList(  new ItemModel(1, 53.38, 45),
                                                    new ItemModel(2, 88.62, 98),
                                                    new ItemModel(3, 78.48, 3));
        assertEquals(81, testPackage.getMaxWeight());
        assertTrue(Arrays.equals(testItems.toArray(), testPackage.getItems().toArray()));
    }
}