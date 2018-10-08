package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.PackageModel;

import java.util.List;

public interface Parser {

    List<PackageModel> parseFile(String path) throws APIException;
}
