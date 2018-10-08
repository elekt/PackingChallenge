package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.PackageModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageParser {

    //1. Max weight that a package can take is ≤ 100
    //2. There might be up to 15 items you need to choose from
    //3. Max weight and cost of an item is ≤ 100

    public PackageModel parsePackage(String path) throws APIException {


        return new PackageModel(0, null);
    }
}
