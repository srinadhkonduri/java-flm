package com.oops_part_5_solid_priciples_ecommerece_system;

public class Main {
    public static void main(String[] args) {

        // step 1. create a product
        Product mouse = new Product("mouse",599.0,2);
        Product keyboard = new Product("keyboard",249.0,2);

        // create an order to process it
        Order order1 = new Order(1001);
        order1.addProduct(mouse);
        order1.addProduct(keyboard);

        System.out.println();
        order1.showOrderSummary();

        // Step 3: Choose payment method and notification method (plugged in from outside!)
        PaymentMethod payment = new UpiPayment("ravi@okhdfc");
        NotificationService notifier = new SmsNotification("9876543210");

        OrderProcessor orderProcessor = new OrderProcessor(payment,notifier);

        System.out.println();
        orderProcessor.processOrder(order1);

        System.out.println();
        order1.showOrderSummary();


        Product laptopBag = new Product("Laptop Bag", 1299.0, 1);
        Order order2 = new Order(1002);
        order2.addProduct(laptopBag);

        PaymentMethod paymentMethod = new CreditCardPayment("1234567890");
        NotificationService service = new EmailNotification("tony@gmail.com");
        OrderProcessor orderProcessor1 = new OrderProcessor(paymentMethod,service);

        System.out.println();
        orderProcessor1.processOrder(order2);

        System.out.println();
        order2.showOrderSummary();
    }
}
