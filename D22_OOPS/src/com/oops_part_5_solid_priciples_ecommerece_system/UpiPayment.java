package com.oops_part_5_solid_priciples_ecommerece_system;

public class UpiPayment implements PaymentMethod {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying ₹" + amount + " using UPI ID: " + upiId);
        return true;
    }
}
