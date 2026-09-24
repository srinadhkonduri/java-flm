package com.oops_part_5_solid_priciples_ecommerece_system;

public class CreditCardPayment implements PaymentMethod{

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying ₹" + amount + " using Credit Card ending in "
                + cardNumber.substring(cardNumber.length() - 4));
        // pretend this is where real bank API logic would go
        return true;
    }
}
