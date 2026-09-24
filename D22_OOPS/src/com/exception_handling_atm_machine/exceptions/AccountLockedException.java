package com.exception_handling_atm_machine.exceptions;

public class AccountLockedException extends RuntimeException{

    public AccountLockedException(String message) {
        super(message);
    }
}
