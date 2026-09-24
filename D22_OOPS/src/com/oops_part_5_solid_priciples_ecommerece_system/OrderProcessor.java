package com.oops_part_5_solid_priciples_ecommerece_system;

public class OrderProcessor {
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderProcessor(PaymentMethod paymentMethod, NotificationService notificationService) {
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order){
        double totalAmount = order.calculateTotalAmount();

        System.out.println("Processing Order #" + order.getOrderId() + "...");
        boolean success = paymentMethod.pay(totalAmount);

        if (success){
            order.markAsPaid();
            notificationService.sendNotification(
                    "Your order #" + order.getOrderId() + " worth ₹" + totalAmount + " is confirmed!"
            );
        } else {
            System.out.println("Payment failed for Order #" + order.getOrderId());
        }
    }
}
