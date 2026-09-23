package com.oops_part_2_polymorphism;

public class NetBankingPayment extends PaymentMethod {

    private String bankName;
    private String accountNumber;
    private String ifcsCode;
    private String password;


    public NetBankingPayment(String transactionId, String accountNumber, String ifcsCode, String password, String bankName) {
        super(transactionId);
        this.accountNumber = accountNumber;
        this.ifcsCode = ifcsCode;
        this.password = password;
        this.bankName = bankName;
    }



    @Override
    boolean pay(double amount) {
        boolean invalid = accountNumber == null || accountNumber.length() != 16
                || ifcsCode == null
                || ifcsCode.length() != 11
                || password == null
                || password.length() != 4;

        if (invalid){
            System.out.println("invalid bank details");
            return false;
        }

        if (amount <= 0){
            System.out.println("no sufficient balance");
            return false;
        }

        System.out.println("payment successful with bank : " + bankName);
        System.out.println("amount" + amount);

        return true;
    }
}
