package com.oops_part_1_inheritance.single_inheritance;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BankAccount account = new SavingsAccount("12345","nani",50000,4);

        SavingsAccount savingsAccount = (SavingsAccount) account; // down casting

        while (true){
            System.out.println("WELCOME TO BANK MANAGEMENT SYSTEM");
            System.out.println("1. display details");
            System.out.println("2. add money");
            System.out.println("3. withdraw money");
            System.out.println("4. add interest");
            System.out.println("5. exit");

            System.out.println("Enter a option");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    account.displayDetails();
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit");
                    account.deposit(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter the money to withdraw : ");
                    account.withDraw(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 4:
                    savingsAccount.addInterest();
                    break;
                case 5:
                    System.out.println("thank you");
                    return;
                default:
                    System.out.println("enter the correct options : ");
            }
        }
    }
}
