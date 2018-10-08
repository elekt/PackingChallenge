package com.mobiquityinc;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;

/**
 * Main program of the knapsack solver
 * It expects a command line parameter as the absolute path to the file that contains the problem to solve
 *
 * @author Tamas Elekes
 */
public class Main {

    public static void main(String[] args) throws APIException {
        if(args.length < 1) {
            throw new APIException("No input parameter passed");
        }

        String path = args[0];
        System.out.println(Packer.pack(path));
    }
}
