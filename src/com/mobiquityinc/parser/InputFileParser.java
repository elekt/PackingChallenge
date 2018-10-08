package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.PackageModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputFileParser {

    public List<PackageModel> parseFile(String path) throws APIException {
        List<PackageModel> packages = new ArrayList<>();

        if (!new File(path).isFile()) {
            throw new APIException("Input parameter is not a file");
        }

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            throw new APIException(String.format("I/O exception while opening file %s", e.getMessage()));
        }


        return packages;
    }

}
