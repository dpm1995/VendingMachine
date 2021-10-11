package com.techelevator;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PurchaseMenu {
    public double currentWallet;
    private NumberFormat dollarValue = NumberFormat.getCurrencyInstance();

    private int currentStock = 5;

    public PurchaseMenu(Scanner prices, Integer openingStock) throws FileNotFoundException {//You need to figure out what to pass in here
        super();
    }

    public int subMenu(String choice) {
        Scanner userInput = new Scanner(System.in);
        String purchase = "";
        while (!purchase.equals("3")) {
            System.out.println("Please pick from the following options: ");
            System.out.println("1) Feed money");
            System.out.println("2) Select Product");
            System.out.println("3) Finish Transaction");
            System.out.println();
            System.out.println("Current Money Provided: " + dollarValue.format(this.currentWallet));

            purchase = userInput.nextLine();
            switch (purchase) {
                case "1":
                    insertMoney();
                    break;
                case "2": //Call the purchase class here, which will call out the
                    AuditLog newSale = new AuditLog();
                    Transaction sale = new Transaction(currentWallet);
                    sale.setWallet(currentWallet);
                    currentWallet = sale.Purchase(currentWallet);
                    break;
                case "3":
                    Change finishTransaction = new Change();
                    finishTransaction.dispenseChange(this.currentWallet);
                    return 3;
                default:
                    System.out.println("Not a valid choice, try again.");
                    break;
            }
        }
        return 3;
    }

    public PurchaseMenu() {

    }

    public Double getCurrentWallet() {;
        return currentWallet;
    }

    public Double insertMoney(){
        Scanner input = new Scanner(System.in);
        String continueInput = "";
        Double deposit;
        AuditLog moneyTransaction = new AuditLog();
        this.currentWallet = getCurrentWallet();
        System.out.println("Please insert a whole dollar amount. ");
        do {
            deposit = input.nextDouble();
            try {
                if (deposit instanceof Double) {
                    System.out.println("You deposited " + dollarValue.format(deposit)
                            + " dollars.");
                    System.out.println();
                }
            } catch (InputMismatchException notMoney){
                System.out.println("That's an invalid input. ");
                break;
            }
            if (deposit != Math.floor(deposit)){
                System.out.println("Invalid money inserted, please try again. ");
                continue;
            }
            currentWallet += deposit;
            String startWallet = dollarValue.format(currentWallet);
            String newWallet = dollarValue.format(currentWallet);
            moneyTransaction.logEvent("FEED Money", startWallet, newWallet);
            System.out.println("Please insert more, or press 0 to return to the purchase menu. ");
        } while (deposit > 1.0);
        return currentWallet;
    }
}
