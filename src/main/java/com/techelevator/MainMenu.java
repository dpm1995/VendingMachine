package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class MainMenu {
    private Scanner userInput = new Scanner(System.in);
    private InventoryReader choice1 = new InventoryReader();
    private PurchaseMenu sale = new PurchaseMenu();

    public MainMenu() {

    }

    public void openMenu(){

        FileReader initialInventory = new FileReader(); //Call fileReader now so you can give initial
        System.out.println("Welcome to the Vendo-Matic 800, pick from one of the following options. ");

        initialInventory.setInputFile();

        System.out.println("1) Display Vendo-Matic Items");
        System.out.println("2) Buy from Vendo-Matic");
        System.out.println("3) Exit");

        String mainChoice = userInput.nextLine();

        do {
            switch (mainChoice) {
                case "1":
                    System.out.println(choice1.currentInventory());
                    break;
                case "2":
                    sale.subMenu(mainChoice);
                    break;
                case "3":
                    System.out.println("Thanks for shopping with Vendo-Matic, have a good day! ");
                    System.exit(0);
                default:
                    System.out.println("That is not a valid answer, so we'll ask again.");
            }
            System.out.println("What would you like to do next? ");
            mainChoice = userInput.nextLine();
        } while (!mainChoice.equals("3"));
    }
}
