package com.oops_part_1_inheritance.single_inheritance;

public class CurrentAccount extends BankAccount{
    private double overDraftLimit;


    public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overDraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overDraftLimit = overDraftLimit;
    }

    public void showOverDraftLimit(){
        System.out.println("over draft limit : " + overDraftLimit);
    }

    @Override
    public void withDraw(double amount) {
        if (amount  > balance + overDraftLimit){
            System.out.println("over draft limit exceeded");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
    }


}
