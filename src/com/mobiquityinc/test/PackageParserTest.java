package com.mobiquityinc.test;

import com.mobiquityinc.model.ItemModel;
import com.mobiquityinc.model.PackageModel;
import com.mobiquityinc.parser.PackageParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PackageParserTest {

    @Test
    void testParsePackage() {
        PackageParser packageParser = new PackageParser();

        PackageModel testPackage = packageParser.parsePackage("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)");

        assertEquals(81, testPackage.getMaxWeight());
        // TODO test
        assertEquals(null, testPackage.getItems());
    }
}