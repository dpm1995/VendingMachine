package com.techelevator;

import java.text.NumberFormat;
import java.util.*;

public class InventoryReader {
    private final FileReader inventory = new FileReader();
    private NumberFormat dollarValue = NumberFormat.getCurrencyInstance();
    public Map<String, Double> codeToPrice = new HashMap<>();
    public Map<String, Integer> codeToStock = new HashMap<>();
    public Map<String, String> codeToName = new HashMap<>();
    public Map<String, String> codeToGroup = new HashMap<>();
    public List<String> inventoryList;
    private String[] itemInfo = new String[5];
    private final String[] itemCodes = new String[] {"A1", "A2", "A3", "A4",
            "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "D4"};
    private String code;
    private int stock = 5;

    public InventoryReader(){
        final FileReader inventory = this.inventory;
        this.inventoryList = inventory.createVendingMachineList(inventory.setInputFile());
    }

    public Map<String, String> currentInventory () {
        List runningList = getInventoryList();  //Puts the current instance of the inventory.
        String emptyItem = "";
        Map<String, String> currentInventory = new HashMap<>();
        Map itemName = inventoryNameParsing();
        Map itemPrice = inventoryPriceParsing();
        Map <String, Integer> itemStock = inventoryCountParsing();
        Map itemGroup = inventoryGroupParsing();
        for (int i = 0; i < runningList.size(); i++) {
            String dollarFormat = dollarValue.format(itemPrice.get(itemCodes[i]));
            currentInventory.put(itemCodes[i], "|" + itemName.get(itemCodes[i]) + "|" + dollarFormat
                    + "|" + itemGroup.get(itemCodes[i]) + "|" + itemStock.get(itemCodes[i]));
            if (itemStock.containsValue(0)) {
                for (Map.Entry<String, Integer> emptyStock : itemStock.entrySet()){
                    emptyItem = emptyStock.getKey();
                }
                currentInventory.put(emptyItem, "is currently out of stock.");
            }
        }
        return currentInventory;
    }

    public Map<String, Integer> inventoryCountParsing(){
        Map<String, Integer> stocks = this.codeToStock;
        for (int i = 0; i < inventoryList.size(); i++) {
            stocks.put(this.itemCodes[i], 5);
            this.codeToStock.put(itemCodes[i], 5);
        }
        return stocks;
    }

    public Map<String, String> inventoryGroupParsing(){
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            String itemGroup = itemInfo[3];
            this.codeToGroup.put(itemInfo[0], itemGroup);
        }
        return codeToGroup;
    }

    public Map<String, Double> inventoryPriceParsing(){
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            double itemPrice = Double.parseDouble(itemInfo[2]);
            this.codeToPrice.put(itemInfo[0], itemPrice);
        }
        return codeToPrice;
    }

    public Map<String, String> inventoryNameParsing(){
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            this.codeToName.put(itemInfo[0], itemInfo[1]);
        }
        return codeToName;
    }

    public void updateStock(String code){
        this.codeToStock.put(code, codeToStock.get(code) - 1);
    }

    public Map<String, Integer> getCodeToStock() {
        return codeToStock;
    }

    public List<String> getInventoryList() {
        return inventoryList;
    }
}
