package com.oops_part_1_inheritance.single_inheritance;

public class Main1 {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new SavingsAccount("SB1", "Ravi", 5000, 4),
                new CurrentAccount("CA1", "Sita", 3000, 2000)
        };

        for (BankAccount bankAccount : accounts){
            bankAccount.withDraw(500); // polymorphism each objects runs its own version

            if (bankAccount instanceof SavingsAccount sa){
                sa.addInterest(); // only savings interest
            } else if (bankAccount instanceof CurrentAccount ca) {
                ca.showOverDraftLimit(); // only current account
            }
        }

    }
}
