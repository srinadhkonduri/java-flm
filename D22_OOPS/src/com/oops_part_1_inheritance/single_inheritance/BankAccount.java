package com.oops_part_1_inheritance.single_inheritance;

// parent class
public class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }


    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("deposit amount must be greater than zero");
            return;
        }
        balance += amount;
        System.out.println("deposited amount : " + amount + " " +" balance is : " + balance);
    }


    public void withDraw(double amount){
        if (amount > balance){
            System.out.println("not enough balance");
            return;
        }
        balance -= amount;
        System.out.println("withdraw amount is : " + amount + " balance is : " + balance);
    }


    public void displayDetails() {
        System.out.println("account number : " + accountNumber + ". "
        + " account holder name : " + accountHolderName + ". "
        + " balance is : "  + balance);
    }

}
