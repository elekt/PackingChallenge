package com.mobiquityinc.exception;

/**
 * General runtime exception class, that is used for throwing errors regarding the input data.
 *
 * @author  Tamas Elekes
 */
public class APIException extends RuntimeException{

    public APIException(String message) {
        super(message);
    }
}
