package com.oops_part_5_solid_priciples_ecommerece_system;

public class NetBanking implements PaymentMethod{

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying ₹" + amount + " using Net Banking");
        return true;
    }
}
