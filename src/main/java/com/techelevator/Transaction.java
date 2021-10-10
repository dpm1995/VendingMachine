package com.techelevator;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Transaction {
    private double wallet;
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
        String startingWallet = String.valueOf(getWallet());
        FileReader forSale = new FileReader();
        String transaction = "Sale";
        double price;
        int stock;

        System.out.print("Please enter the code of your desired product: ");
        code = userInput.next().toUpperCase(Locale.ROOT); //Takes in item code to disburse to check item info
        Map<String, String> itemName = itemLookup.getCodeToName();
        Map<String, Double> itemPrice = itemLookup.getCodeToPrice();
        Map<String, Integer> itemStock = itemLookup.getCodeToStock();
        price = itemPrice.get(code); //Sets price to check in the audit
        stock = itemStock.get(code); //Sets stock count to check in the audit
        /*
        Call the inventory Reader here, get the coordinates back so you can
         */
        if (sell.validSale(wallet, price, stock)){//Boolean method from the audit log class
            wallet -= price;
            String postSale = String.valueOf(wallet);
            itemLookup.updateStock(code);
            sell.logEvent(itemName.get(code) + code, startingWallet, postSale);
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
