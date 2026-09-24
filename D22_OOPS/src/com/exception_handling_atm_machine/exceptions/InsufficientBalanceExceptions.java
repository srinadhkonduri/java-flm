package com.exception_handling_atm_machine.exceptions;

public class InsufficientBalanceExceptions extends Exception{
    private final double shortBy;

    public InsufficientBalanceExceptions(String message, double shortBy) {
        super(message);
        this.shortBy = shortBy;
    }

    public double getShortBy() {
        return shortBy;
    }
}
