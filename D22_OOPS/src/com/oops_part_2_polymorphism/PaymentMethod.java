package com.oops_part_2_polymorphism;


// here you can also make use of the interface
abstract public class PaymentMethod {

    protected String transactionId;

    public PaymentMethod(String transactionId) {
        this.transactionId = transactionId;
    }

    // every subclass MUST implement this differently
    // this is what runtime polymorphism will call through a parent reference
    abstract boolean pay(double amount);
}
