package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PurchaseMenu {
    private int singleItemInfoSpot;
    public double currentWallet;

    private int currentStock = 5;

    public PurchaseMenu(Scanner prices, int openingStock) throws FileNotFoundException {//You need to figure out what to pass in here
        super();
    }

    public void subMenu(String choice) {
        Scanner userInput = new Scanner(System.in);
        String purchase;
        do {
            System.out.println("Please pick from the following options: ");
            System.out.println("1) Feed money");
            System.out.println("2) Select Product");
            System.out.println("3) Finish Transaction");
            System.out.println();
            System.out.println("Current Money Provided: \\$" + this.currentWallet);

            purchase = userInput.nextLine();
            switch (purchase) {
                case "1":
                    insertMoney();
                    System.out.println("Is there anything else we can do for you today? ");
                    break;
                case "2": //Call the purchase class here, which will call out the
                    AuditLog newSale = new AuditLog();
                    Transaction sale = new Transaction(currentWallet);
                    sale.setWallet(currentWallet);
                    sale.Purchase(currentWallet);
                    System.out.println("Is there anything else we can do for you today? ");
                    break;
                case "3": //Call the finish transaction class.
                    Change finishTransaction = new Change();
                    finishTransaction.dispenseChange(this.currentWallet);
                    break;
                default:
                    System.out.println("Not a valid choice, try again.");
            }
        } while (!purchase.equals("3"));

    }

    public PurchaseMenu() {

    }

    public double getCurrentWallet() {;
        return currentWallet;
    }

    public double insertMoney(){
        Scanner input = new Scanner(System.in);
        AuditLog moneyTransaction = new AuditLog();
        String moreMoney = "";
        this.currentWallet = getCurrentWallet();
        do {
            System.out.println("How much are you putting in? ");
            double deposit = input.nextDouble();
            if (deposit != Math.floor(deposit)){
                System.out.println("Invalid money inserted, please try again. ");
                continue;
            }
            String startWallet = String.valueOf(deposit) + "0";
            currentWallet += deposit;
            String newWallet = String.valueOf(currentWallet) + "0";
            moneyTransaction.logEvent("FEED Money", startWallet, newWallet);
            System.out.println("Would you like to insert more? ");
            moreMoney = input.nextLine();
        } while (moreMoney.equals("y"));
        return currentWallet;
    }
}
