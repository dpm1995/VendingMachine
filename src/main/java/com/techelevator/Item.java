package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Item {
    // Instance Variables
    private String name;
    private Double price;
    private String slot;
    private String noise;
    private String itemCount;

    //Constructor
    public Item(String slot) {
        this.itemCount = "5"; // max value
        this.slot = slot; // A1..A2..A3.. etc
    }

    // Utilizes method in fileReader class to parse through the csv file using the regular expression | as a delimiter to return name
    public String getName() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        List<String> outputList = new ArrayList<String>();
        outputList = file.createVendingMachineList(inputFile);
        for (int i = 0; i < outputList.size(); i++) {
            String[] splitLine = outputList.get(i).split("\\|");
            if (splitLine[0].equals(slot)) {
                name = splitLine[1];
            }
        }
        return name;
    }

    // Utilizes method in fileReader class to parse through the csv file using the regular expression | as a delimiter to return price
    public Double getPrice() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        List<String> outputList = new ArrayList<String>();
        outputList = file.createVendingMachineList(inputFile);
        for (int i = 0; i < outputList.size(); i++) {
            String[] splitLine = outputList.get(i).split("\\|");
            if (splitLine[0].equals(slot)) {
                price = Double.valueOf(splitLine[2]);
            }
        }
        return price;
    }

    // returns noise of item provided in each individual item's class
    public String makeNoise() {
        return noise;
    }

    // Getter for max value of 5
    public String getItemCount() {
        return itemCount;
    }

    // method for purchasing item and provided a message if sold out
    public void purchaseItem() {
        Integer currentCount = Integer.parseInt(itemCount) - 1;
        if (currentCount > 0) {
            itemCount = String.valueOf(currentCount);
        } else {
            itemCount = "SOLD OUT";
        }
    }
}
