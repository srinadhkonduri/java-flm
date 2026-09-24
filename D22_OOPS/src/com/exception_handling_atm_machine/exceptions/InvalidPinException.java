package com.exception_handling_atm_machine.exceptions;

public class InvalidPinException extends RuntimeException {

    public InvalidPinException(String message) {
        super(message);
    }
}
