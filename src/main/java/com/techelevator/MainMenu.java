package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class MainMenu {
    private Scanner userInput = new Scanner(System.in);
    private final File inventory = new File("C:\\Users\\Student\\workspace\\java-capstone-module-1-team-11\\vendingmachine.csv");

    public MainMenu() throws FileNotFoundException {
        if (!inventory.exists()) { //Since inventory is a file that's reused, here's the exception throw since I can't
            throw new FileNotFoundException("Our inventory is currently having issues, sorry!"); //outside the class.
        }

        Scanner inventoryInput = new Scanner(inventory);
        System.out.println("Welcome to the Vendo-Matic 800, pick from one of the following options. ");
        System.out.println("1) Display Vendo-Matic Items");
        System.out.println("2) Buy from Vendo-Matic");
        System.out.println("3) Exit");

        String mainChoice = userInput.nextLine();

        do {
            switch (mainChoice) {
                case "1":
                    while (inventoryInput.hasNext()) {
                        System.out.println(inventoryInput);
                    }
                    break;
                case "2":
                    PurchaseMenu sale = new PurchaseMenu(); //Need a new variable (type maybe?)
                    break;
                case "3":
                    System.out.println("Thanks for shopping with Vendo-Matic, have a good day! ");
                    System.exit(0);
                case "4":
                    SalesReport report = new SalesReport(); //Placeholder for sales report class if I get to it.
                    break;
            }
            System.out.println("What would you like to do next? ");
            mainChoice = userInput.nextLine();
        } while (!mainChoice.equals("3"));
    }
}
