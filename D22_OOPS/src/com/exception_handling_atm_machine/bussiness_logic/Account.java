package com.exception_handling_atm_machine.bussiness_logic;

import com.exception_handling_atm_machine.exceptions.AccountLockedException;
import com.exception_handling_atm_machine.exceptions.InsufficientBalanceExceptions;
import com.exception_handling_atm_machine.exceptions.InvalidPinException;
import com.exception_handling_atm_machine.exceptions.ReceiptPrintException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Account {
    private final String holder;
    private final int pin;
    private double balance;
    private int wrongTries = 0;
    private boolean locked = false;

    public Account(String holder, int pin, double balance) {
        this.holder = holder;
        this.pin = pin;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void verifyPin(int entered){
        if (locked){
            throw new AccountLockedException("Card is blocked. Please visit the bank");
        }
        if (entered != pin){
            wrongTries++;
            if (wrongTries >= 3){
                locked = true;
                throw new AccountLockedException("3 wrong pins! card blocked");
            }
            throw new InvalidPinException("Wrong pin attempts left : " + (3-wrongTries));
        }
        wrongTries = 0;
    }

    public void withdraw(double amount) throws InsufficientBalanceExceptions {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be more than 0");
        }
        if (amount > balance) {
            throw new InsufficientBalanceExceptions("Not enough balance", amount - balance);
        }
        balance -= amount;
    }

    public void printReceipt(String path, double amount) throws ReceiptPrintException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.println("Holder : " + holder);
            out.println("Taken  : " + amount);
            out.println("Balance: " + balance);
        } catch (IOException e) {
            // wrap the low-level error into our own meaningful one
            throw new ReceiptPrintException("Could not print receipt", e);
        }
    }
}
