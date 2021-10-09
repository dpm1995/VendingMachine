package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader {
    // Instance Variables
    private File inputFile;
    private List<String> outputList = new ArrayList<String>();

    // Constructor
    public File setInputFile() {
        inputFile = new File("C:\\Users\\Student\\workspace\\java-capstone-module-1-team-11\\vendingmachine.csv");
        return inputFile;
    }


    // Parses though entire csv file line by line while there is still a line to read
    public List<String> createVendingMachineList(File inputFile) {

        try(Scanner readFile = new Scanner(inputFile)) {
            while(readFile.hasNextLine()) {
                outputList.add(readFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outputList;

    }

}
