package com.techelevator;

import java.util.Scanner;

public class Transaction {
    private double wallet;
    private int stock; //Put a map in here to track stock with item code
    private String code;
    private Scanner userInput = new Scanner(System.in);
    private InventoryReader itemLookup = new InventoryReader();
    private AuditLog sell = new AuditLog();

    public Transaction(Double wallet) {
        FileReader forSale = new FileReader();
        System.out.print("Please enter the code of your desired product: ");
        code = userInput.next();
        double price = itemLookup.itemPrice(code);
        stock = itemLookup.itemStock(code);
        /*
        Call the inventory Reader here, get the coordinates back so you can
         */
        if (sell.validSale(wallet, price, stock)){//Boolean method from the audit log class
            wallet -= price;
            itemLookup.updateStock(code);
        } else {
            System.out.println("Invalid sale");
        }
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
