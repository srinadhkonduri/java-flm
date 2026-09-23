package com.oops_part_2_polymorphism;

public class Main {
    public static void main(String[] args) {

        PaymentMethod upiPayment = new UpiPayment("123456","nani@upi");

        PaymentMethod card = new CardPayment("TXN1002", "1234567812345678",
                12, 2027, 456, "1234");

        PaymentMethod netBanking = new NetBankingPayment("TXN1003",
                "1234567890123456", "SBIN0001234",
                "1234", "State Bank of India");


        PaymentProcessor processor = new PaymentProcessor();

        // Same method call, three different behaviors — polymorphism in action
        processor.processPayment(upiPayment,500);
        processor.processPayment(card,2000);
        processor.processPayment(netBanking,1500);

    }
}
