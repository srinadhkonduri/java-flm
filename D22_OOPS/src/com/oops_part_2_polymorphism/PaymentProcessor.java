package com.oops_part_2_polymorphism;

public class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {

        System.out.println("---- starting method ----");
        boolean success = method.pay(amount);


        if (success) {
            System.out.println("payment done");
        }
        else {
            System.out.println("payment failed");
        }
    }
}
