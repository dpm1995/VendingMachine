package com.techelevator;

import java.util.*;

public class InventoryReader {
    private final FileReader inventory = new FileReader();
    private Map<String, Double> codeToPrice = new HashMap<>();
    private Map<String, Integer> codeToStock = new HashMap<>();
    private Map<String, String> codeToName = new HashMap<>();
    private List<String> inventoryList;
    private String[] itemInfo = new String[5];
    private String code;

    public InventoryReader(){
        final FileReader inventory = this.inventory;
        this.inventoryList = inventory.createVendingMachineList(inventory.setInputFile());
    }

    public Map<String, String> currentInventory () {
        Map<String, String> currentInventory = new HashMap<>();
        String itemCode = getCode();
        String itemName = this.codeToName.get(itemCode);
        String itemPrice = Double.toString(this.codeToPrice.get(itemCode));
        String itemStock = Integer.toString(this.codeToStock.get(itemCode));
        String itemGroup;
        try {
            if (itemCode.charAt(0) == 'A') {
                itemGroup = "Candy";
            } else if (itemCode.charAt(0) == 'B') {
                itemGroup = "Chip";
            } else if (itemCode.charAt(0) == 'C') {
                itemGroup = "Drink";
            }
            if (itemCode.charAt(0) == 'D') {
                itemGroup = "Gum";
            } else {
                itemGroup = null;
            }
            currentInventory.put(itemCode, "|" + itemName + "|" + itemPrice + "|" +
                    itemGroup + "|" + itemStock);
        } catch (NullPointerException badCode) {
            System.out.println("Item not found. ");
        }
        if (itemStock.equals("0")) {
            currentInventory.put(itemCode, "is currently out of stock.");
        }
        return currentInventory;
    }

    public Map<String, Integer> inventoryCountParsing(){ //Figure out how to call a code that
        List<String> itemDetails = this.inventoryList;   //Returns the info from here. Use that
        for (int i = 0; i < itemDetails.size(); i++) {        //For log writing. Have said method(s)
            itemInfo = itemDetails.get(i).split("\\|"); //Take maps for each criteria.
            int itemCount = Integer.parseInt(itemInfo[3]);
            codeToStock.put(itemInfo[0], itemCount);
        }
        return codeToStock;
    }

    public Map<String, Double> inventoryPriceParsing(){
        List<String> itemDetails = this.inventoryList;
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            double itemPrice = Double.parseDouble(itemInfo[2]);
            codeToPrice.put(itemInfo[0], itemPrice);
        }
        return codeToPrice;
    }

    public Map<String, String> inventoryNameParsing(){
        List<String> itemDetails = this.inventoryList;
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            codeToName.put(itemInfo[0], itemInfo[1]);
        }
        return codeToName;
    }

    public double itemPrice(String code){
        double price = this.codeToPrice.get(code);
        return price;
    }

    public void updateStock(String code){
        this.codeToStock.put(code, codeToStock.get(code) - 1);
    }

    public int viewStock(String code){
        int count = this.codeToStock.get(code);
        return count;
    }

    public Map<String, String> getCodeToName() {
        return codeToName;
    }

    public void setCodeToName(Map<String, String> codeToName) {
        this.codeToName = codeToName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FileReader getInventory() {
        return inventory;
    }

    public Map<String, Double> getCodeToPrice() {
        return codeToPrice;
    } //HAVE AUDIT LOG CALL THIS

    public void setCodeToPrice(Map<String, Double> codeToPrice) {
        this.codeToPrice = codeToPrice;
    }

    public Map<String, Integer> getCodeToStock() {
        return codeToStock;
    }

    public void setCodeToStock(Map<String, Integer> codeToStock) {
        this.codeToStock = codeToStock;
    }

    public List<String> getInventoryList() {
        return inventoryList;
    }
}
