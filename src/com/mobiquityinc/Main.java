package com.mobiquityinc;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;

import java.io.File;

public class Main {

    public static void main(String[] args) throws APIException {

        if(args.length < 1) {
            throw new APIException("No input parameter passed");
        }

        String path = args[0];

        String ret = Packer.pack(path);

        System.out.println(ret);
    }
}
