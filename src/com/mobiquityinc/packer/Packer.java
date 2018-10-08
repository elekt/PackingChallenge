package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.PackageModel;
import com.mobiquityinc.parser.InputFileParser;

import java.util.List;

public class Packer {

    public static String pack(String path) throws APIException {
        String ret = "";

        InputFileParser inputParser = new InputFileParser();
        List<PackageModel> packages = inputParser.parseFile(path);

        return ret;
    }
}
