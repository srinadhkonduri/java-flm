package com.oops_part_5_solid_priciples_ecommerece_system;

public class SmsNotification implements NotificationService{
    private String phoneNumber;

    public SmsNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
