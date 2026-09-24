package com.oops_part_5_solid_priciples_ecommerece_system;

public class CashOnDeliveryPayment implements PaymentMethod{

    @Override
    public boolean pay(double amount) {
        System.out.println("₹" + amount + " will be collected as Cash on Delivery");
        return true;
    }

}
