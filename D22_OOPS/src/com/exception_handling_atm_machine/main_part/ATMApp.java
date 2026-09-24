package com.exception_handling_atm_machine.main_part;

import com.exception_handling_atm_machine.bussiness_logic.Account;
import com.exception_handling_atm_machine.exceptions.AccountLockedException;
import com.exception_handling_atm_machine.exceptions.InsufficientBalanceExceptions;
import com.exception_handling_atm_machine.exceptions.InvalidPinException;
import com.exception_handling_atm_machine.exceptions.ReceiptPrintException;

import java.io.*;

public class ATMApp {
    public static void main(String[] args) {
        part1BuiltInExceptions();
        part2TryCatchFinally();
        part3CustomExceptionsAtmFlow();
        part4ChainingAndTryWithResources();
    }

    static void part1BuiltInExceptions(){
        header("part 1: BUILT IN EXCEPTIONS");

        try {
            int r = 10/0;
        } catch (ArithmeticException e){
            show("ArithmeticException", e);
        }
        try { String s = null; s.length(); }
        catch (NullPointerException e) { show("NullPointerException", e); }

        try { int[] arr = new int[3]; arr[5] = 1; }
        catch (ArrayIndexOutOfBoundsException e) { show("ArrayIndexOutOfBounds", e); }

        try { Integer.parseInt("abc"); }
        catch (NumberFormatException e) { show("NumberFormatException", e); }

        try { Object o = "hello"; Integer i = (Integer) o; }
        catch (ClassCastException e) { show("ClassCastException", e); }

        try { "hi".charAt(10); }
        catch (StringIndexOutOfBoundsException e) { show("StringIndexOutOfBounds", e); }

        // CHECKED: compiler forces us to handle this one
        try { new FileReader("no_such_file.txt"); }
        catch (FileNotFoundException e) { show("FileNotFoundException (checked)", e); }

        // ERROR (not Exception): serious JVM problem, normally you don't catch these
        try { recurseForever(1); }
        catch (StackOverflowError e) { System.out.println("  StackOverflowError (an Error, not Exception)"); }
    }

    static int recurseForever(int n) { return recurseForever(n + 1); }

    static void part2TryCatchFinally() {
        header("PART 2: try, catch, multi-catch, finally");

        for (String input : new String[]{"500", "abc", null}) {
            try {
                System.out.println("  User typed: " + input);
                int amount = Integer.parseInt(input.trim());
                System.out.println("  Parsed OK: " + amount);
            } catch (NumberFormatException | NullPointerException e) { // multi-catch
                System.out.println("  Bad input -> " + e.getClass().getSimpleName());
            } finally {
                // ALWAYS runs: success or failure
                System.out.println("  [finally] ATM screen reset\n");
            }
        }
    }


    // ---------- PART 3: real ATM flow with CUSTOM exceptions ----------
    static void part3CustomExceptionsAtmFlow() {
        header("PART 3: ATM flow with custom exceptions");

        Account acc = new Account("Srinadh", 1234, 5000);

        // Scenario A: happy path
        atmSession(acc, 1234, 2000);
        // Scenario B: not enough money
        atmSession(acc, 1234, 9000);
        // Scenario C: negative amount
        atmSession(acc, 1234, -50);
        // Scenario D: wrong PINs until card gets blocked
        atmSession(acc, 1111, 100);
        atmSession(acc, 2222, 100);
        atmSession(acc, 3333, 100);
        atmSession(acc, 1234, 100);   // even right PIN fails now
    }


    static void atmSession(Account acc, int pin, double amount) {
        System.out.println("  --- Session: pin=" + pin + ", amount=" + amount);
        try {
            acc.verifyPin(pin);          // may throw unchecked exceptions
            acc.withdraw(amount);        // may throw checked exception
            System.out.println("  Collect your cash! Balance: " + acc.getBalance());
        } catch (InsufficientBalanceExceptions e) {
            System.out.println("  " + e.getMessage() + ". You are short by " + e.getShortBy());
        } catch (InvalidPinException e) {
            System.out.println("  " + e.getMessage());
        } catch (AccountLockedException e) {
            System.out.println("  BLOCKED: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("  Invalid input: " + e.getMessage());
        } catch (Exception e) {
            // Safety net: ALWAYS keep the general catch LAST
            System.out.println("  Something unexpected: " + e);
        } finally {
            System.out.println("  Card returned.\n");
        }
    }


    // ---------- PART 4: chaining + try-with-resources ----------
    static void part4ChainingAndTryWithResources() {
        header("PART 4: Exception chaining + try-with-resources");

        Account acc = new Account("Srinadh", 1234, 3000);

        try {
            acc.printReceipt("receipt.txt", 500);
            System.out.println("  Receipt printed to receipt.txt");
            acc.printReceipt("/no/such/folder/receipt.txt", 500);   // will fail
        } catch (ReceiptPrintException e) {
            System.out.println("  Our message : " + e.getMessage());
            System.out.println("  Real cause  : " + e.getCause());
        }
    }


    // ---------- helpers ----------
    static void header(String t) { System.out.println("\n=========== " + t + " ===========\n"); }
    static void show(String name, Exception e) { System.out.println("  " + name + " -> " + e.getMessage()); }
}
