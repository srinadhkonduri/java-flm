package com.oops_part_1_inheritance.single_inheritance;

public class SavingsAccount extends BankAccount{

    private double interestRate;


    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }


    // adding interest only child has this
    public void addInterest(){
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + " | Balance: " + balance);
    }

    // Method overriding (child changes the parent's behaviour)

    @Override
    public void withDraw(double amount) {
        if (balance - amount < 1000){
            System.out.println("minimum balance should be 1000");
        }
        super.withDraw(amount); // reuse the parent logic

    }
}
