package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.PackageModel;
import com.mobiquityinc.parser.InputFileParser;

import java.util.List;

/**
 * Packer problem solver.
 *
 * @author  Tamas Elekes
 */
public class Packer {

    /**
     * @param path absolute path to the input file
     */
    public static String pack(String path) throws APIException {
        StringBuilder resultBuilder = new StringBuilder();
        Solver solver = new RecursiveSolver();

        InputFileParser inputParser = new InputFileParser();
        List<PackageModel> packages = inputParser.parseFile(path);


        for(PackageModel p : packages) {
            resultBuilder.append(solver.solve(p));
            resultBuilder.append("\n");
        }

        return resultBuilder.toString();
    }
}
