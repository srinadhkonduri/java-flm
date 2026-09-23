package com.oops_part_2_polymorphism;

public class CardPayment extends PaymentMethod{

    private String cardNumber;
    private int month;
    private int year;
    private int cvv;
    private String  pin;

    public CardPayment(String transactionId, String cardNumber, int month, int year, int cvv, String pin) {
        super(transactionId);
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
        this.pin = pin;
    }

    @Override
    boolean pay(double amount) {
        boolean invalid =
                cardNumber == null || cardNumber.length() != 16 ||
                        month < 1 || month > 12 ||
                        year < 2000 || year > 2050 ||
                        cvv < 100 || cvv > 999 ||
                        pin == null || pin.length() != 4;

        if (invalid){
            System.out.println("card details are wrong");
            return false;
        }

        if (amount <= 0) {
            System.out.println("invalid amount");
            return false;
        }


        System.out.println("transaction done successfully with card number : " + cardNumber);
        System.out.println("amount debited from your account : " + amount);
        return true;
    }


}
