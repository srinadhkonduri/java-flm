package com.oops_part_5_solid_priciples_ecommerece_system;

public class EmailNotification implements NotificationService{

    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending EMAIL to " + emailAddress + ": " + message);
    }
}
