package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.parser.InputFileParser;
import com.mobiquityinc.parser.PackageParser;
import com.mobiquityinc.parser.Parser;

public class Packer {

    public static String pack(String path) throws APIException {
        String ret = "";

        InputFileParser inputParser = new InputFileParser();
        inputParser.parseFile(path);

        return ret;
    }
}
