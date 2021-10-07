package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Gum extends Item {
    // Instance variables
    private String noise;
    private String slot;
    // Constructor
    public Gum(String slot) {
        super(slot);
        this.slot = slot;
    }
    // Override method for noise - utilizes file reader to parse for sound based on reg ex |
    @Override
    public String makeNoise() {
        FileReader file = new FileReader();
        File inputFile = file.setInputFile();
        List <String> outputList = new ArrayList<String>();
        outputList = file.createVendingMachineList(inputFile);
        for(int i=0; i < outputList.size(); i++) {
            String[] splitLine = outputList.get(i).split("\\|");
            if (splitLine[0].equals(slot) && splitLine[3].equals("Gum")) {
                noise = "Chew Chew, Yum!";
            }
        }
        return noise;
    }
    // Getter
    public String getSlot() {
        return slot;
    }
}
