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
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double Purchase(double wallet){
        wallet = getWallet();
        FileReader forSale = new FileReader();

        System.out.print("Please enter the code of your desired product: ");
        code = userInput.next(); //Takes in item code to disburse to check item info
        itemLookup.setCode(code);
        double price = itemLookup.itemPrice(code); //Sets price to check in the audit
        stock = itemLookup.viewStock(code); //Sets stock count to check in the audit
        /*
        Call the inventory Reader here, get the coordinates back so you can
         */
        if (sell.validSale(wallet, price, stock)){//Boolean method from the audit log class
            wallet -= price;
            itemLookup.updateStock(code);
        } else {
            System.out.println("Invalid sale");
        }
        if (code.charAt(0) == 'A') {
            Candy candySale = new Candy(code);
            candySale.makeNoise();
        } else if (code.charAt(0) == 'B') {
            Chip chipSale = new Chip(code);
            chipSale.makeNoise();
        } else if (code.charAt(0) == 'C') {
            Drink drinkSale = new Drink(code);
            drinkSale.makeNoise();
        } else if (code.charAt(0) == 'D') {
            Gum gumSale = new Gum(code);
            gumSale.makeNoise();
        }
        return wallet;
    }
}
