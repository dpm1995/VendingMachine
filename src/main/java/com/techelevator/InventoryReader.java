package com.techelevator;

import java.util.*;

public class InventoryReader {
    private final FileReader inventory = new FileReader();
    public Map<String, Double> codeToPrice = new HashMap<>();
    public Map<String, Integer> codeToStock = new HashMap<>();
    public Map<String, String> codeToName = new HashMap<>();
    public Map<String, String> codeToGroup = new HashMap<>();
    public List<String> inventoryList;
    private String[] itemInfo = new String[5];
    private String code;
    private int stock = 5;

    public InventoryReader(){
        final FileReader inventory = this.inventory;
        this.inventoryList = inventory.createVendingMachineList(inventory.setInputFile());
    }

    public Map<String, String> currentInventory () {
        getInventoryList();
        Map<String, String> currentInventory = new HashMap<>();
        String itemCode = getCode();
        Map itemName = inventoryNameParsing();
        Map itemPrice = inventoryPriceParsing();
        Map itemStock = inventoryCountParsing();
        Map itemGroup = inventoryGroupParsing();
        currentInventory.put(itemCode, "|" + itemName.get(code) + "|" + itemPrice.get(code)
                    + "|" + itemGroup.get(code) + "|" + itemStock.get(code));
        if (itemStock.get(code).equals(0)) {
            currentInventory.put(itemCode, "is currently out of stock.");
        }
        return currentInventory;
    }

    public Map<String, Integer> inventoryCountParsing(){
        List<String> itemDetails = getInventoryList();
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            int itemCount = Integer.parseInt(itemInfo[4]);
            this.codeToStock.put(itemInfo[0], itemCount);
        }
        return codeToStock;
    }

    public Map<String, String> inventoryGroupParsing(){
        List<String> itemDetails = getInventoryList();
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            double itemGroup = Double.parseDouble(itemInfo[3]);
            this.codeToPrice.put(itemInfo[0], itemGroup);
        }
        return codeToGroup;
    }

    public Map<String, Double> inventoryPriceParsing(){
        List<String> itemDetails = getInventoryList();
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            double itemPrice = Double.parseDouble(itemInfo[2]);
            this.codeToPrice.put(itemInfo[0], itemPrice);
        }
        return codeToPrice;
    }

    public Map<String, String> inventoryNameParsing(){
        List<String> itemDetails = getInventoryList();
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            this.codeToName.put(itemInfo[0], itemInfo[1]);
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

    public String getCode() {
        return code;
    }

    public FileReader getInventory() {
        return inventory;
    }

    public Map<String, Double> getCodeToPrice() {
        return codeToPrice;
    } //HAVE AUDIT LOG CALL THIS

    public Map<String, Integer> getCodeToStock() {
        return codeToStock;
    }

    public List<String> getInventoryList() {
        return inventoryList;
    }
}
