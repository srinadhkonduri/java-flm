package com.oops_part_2_polymorphism;

public class UpiPayment extends PaymentMethod{
    private String upiId;


    public UpiPayment(String transactionId, String upiId) {
        super(transactionId);
        this.upiId = upiId;
    }


    @Override
    boolean pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount + " via UPI ID: " + upiId);
        System.out.println("Transaction ID: " + transactionId);

        if (amount <= 0) {
            System.out.println("Payment failed: invalid amount");
            return false;
        }

        System.out.println("UPI payment successful!");
        return true;
    }
}
