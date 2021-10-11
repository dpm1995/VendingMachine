package com.techelevator;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transaction {
    private double wallet;
    private Scanner userInput = new Scanner(System.in);
    private InventoryReader itemLookup = new InventoryReader();
    private AuditLog sell = new AuditLog();

    public Transaction(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double Purchase(Double wallet){
        Map<String, String> itemName = new HashMap<>();
        Map<String, Double> itemPrice = new HashMap<>();
        Map<String, Integer> itemStock = new HashMap<>();

        String startingWallet = String.valueOf(getWallet());
        FileReader forSale = new FileReader();
        String transaction = "Sale";

        System.out.print("Please enter the code of your desired product: ");
        String code = userInput.nextLine(); //Takes in item code to disburse to check item info

        try {
            itemPrice = itemLookup.inventoryPriceParsing(); //Sets up variables related to
            itemStock = itemLookup.inventoryCountParsing(); //Each vending machine code
            itemName = itemLookup.inventoryNameParsing();
        } catch (NullPointerException badCode) {
            System.out.println("Invalid vend code.");
        }

        Double price = itemPrice.get(code); //Sets price and stock to check in the audit
        Integer stock = itemStock.get(code);

        if (wallet > price && stock > 0){//Boolean method from the audit log class
            wallet -= price;
            String postSale = String.valueOf(wallet);
            itemLookup.updateStock(code);
            itemLookup.inventoryGroupParsing();
            sell.logEvent(itemName.get(code) + code, startingWallet, postSale);
        } else {
            throw new NullPointerException ("Invalid sale");
        }
        switch (code.substring(0, 1)){
            case "A":
                System.out.println("Munch Munch, Yum!");
                System.out.println();
                break;
            case "B":
                System.out.println("Crunch Crunch, Yum!");
                System.out.println();
                break;
            case "C":
                System.out.println("Glug Glug, Yum!");
                System.out.println();
                break;
            case "D":
                System.out.println("Chew Chew, Yum!");
                System.out.println();
                break;
        }
        return wallet;
    }
}
