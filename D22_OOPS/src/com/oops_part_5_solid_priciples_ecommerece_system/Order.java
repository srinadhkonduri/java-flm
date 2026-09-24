package com.oops_part_5_solid_priciples_ecommerece_system;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;
    private boolean isPaid;

    public Order(int orderId){
        this.orderId = orderId;
        products = new ArrayList<>();
        this.isPaid = false;
    }

    // SAFE DOOR - the only way to add a product to this order
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Invalid product!");
            return;
        }
        products.add(product);
        System.out.println(product.getProductName() + " added to Order #" + orderId);
    }

    // Calculated value - sum of all product totals
    public double calculateTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getTotalPrice();
        }
        return total;
    }

    // SAFE DOOR - only way to mark order as paid, and only the OrderProcessor should call this
    public void markAsPaid() {
        this.isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void showOrderSummary() {
        System.out.println("----- Order #" + orderId + " -----");
        for (Product product : products) {
            System.out.println(product.getProductName() + " x " + product.getQuantity()
                    + " = ₹" + product.getTotalPrice());
        }
        System.out.println("Total: ₹" + calculateTotalAmount());
        System.out.println("Paid: " + isPaid);
    }
}
