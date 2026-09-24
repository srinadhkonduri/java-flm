package com.oops_part_5_solid_priciples_ecommerece_system;

public class Product {

    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        setPrice(price);
        setQuantity(quantity);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0){
            System.out.println("price cannot be -ve");
            return;
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0){
            System.out.println("quantity should be > 0");
        }
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return price * quantity;
    }
}
