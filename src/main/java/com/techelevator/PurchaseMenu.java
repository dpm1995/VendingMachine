package com.techelevator;

import java.util.Scanner;

public class PurchaseMenu {
    private int itemLine;
    private int singleItemInfoSpot;
    private double currentWallet;

    private final int openingStock = 5;

    public PurchaseMenu(Scanner prices, int openingStock) {//You need to figure out what to pass in here
        super();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please pick from the following options: ");
        System.out.println("1) Feed money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: \\$" + this.currentWallet);

        String purchase = userInput.nextLine();
        do {
            switch (purchase) {
                case "1":
                    insertMoney(userInput);
                    break;
                case "2": //
                    break;
                case "3": //Go back to the main menu....how exactly?
                    break;
                default:
                    System.out.println("Not a valid choice, try again.");
            }
        } while (!purchase.equals("3"));
    }

    public PurchaseMenu() {

    }

    public int getOpeningStock() {
        return openingStock;
    }

    public int getItemLine() {
        return itemLine;
    }

    public double getCurrentWallet() {
        return currentWallet;
    }

    public void setItemLine(int itemLine) {
        this.itemLine = itemLine;
    }

    public int getSingleItemInfoSpot() {
        return singleItemInfoSpot;
    }

    public void setSingleItemInfoSpot(int singleItemInfoSpot) {
        this.singleItemInfoSpot = singleItemInfoSpot;
    }

    public void setCurrentWallet(double currentWallet) {
        this.currentWallet = currentWallet;
    }

    public String[][] inventoryReader(Scanner inventory) {
        int itemLine = 0;
        int singleItemInfoSpot = 0;
        int i = 0;
        String[][] totalInventoryArray = new String[16][];
        String inventoryLine = ""; //Need a way to
        while (inventory.hasNext() || i < 16) {
            inventoryLine = inventory.nextLine() + "|" + openingStock;
            String[] singleInventoryArray = inventoryLine.split("\\|");//Come up with a convoluted way to subtract
            totalInventoryArray[i] = singleInventoryArray;					 //from stock
            i++;
        }
        return totalInventoryArray;
    }

    public double insertMoney(Scanner input){
        input = new Scanner(System.in);
        String moreMoney;
        double insertedMoney = 0;
        do {
            System.out.println("How much are you putting in? ");
            insertedMoney += input.nextDouble();
            System.out.println("Would you like to insert more? ");
            moreMoney = input.nextLine();
        } while (moreMoney.equals("y"));
        return insertedMoney;
    }
}
