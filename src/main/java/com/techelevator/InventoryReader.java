package com.techelevator;

import java.util.*;

public class InventoryReader {
    private final FileReader inventory = new FileReader();
    private Map<String, Double> codeToPrice = new HashMap<>();
    private Map<String, Integer> codeToStock = new HashMap<>();
    private Map<String, String> codeToName = new HashMap<>();
    private List<String> inventoryList;
    private String[] itemInfo;

    public InventoryReader(){
        final FileReader inventory = this.inventory;
        this.inventoryList = inventory.createVendingMachineList(inventory.setInputFile());
    }

    public Map<String, Integer> inventoryCountParsing(List<String> itemDetails){
        itemDetails = inventoryList;
        for (int i = 0; i < itemDetails.size(); i++) {
            itemInfo = itemDetails.get(i).split("\\|");
            int itemCount = Integer.parseInt(itemInfo[3]);
            codeToStock.put(itemInfo[0], itemCount);
        }
        return codeToStock;
    }

    public Map<String, Double> inventoryPriceParsing(List<String> itemDetails){
        itemDetails = inventoryList;
        for (int i = 0; i < inventoryList.size(); i++) {
            itemInfo = inventoryList.get(i).split("\\|");
            double itemPrice = Double.parseDouble(itemInfo[2]);
            codeToPrice.put(itemInfo[0], itemPrice);
        }
        return codeToPrice;
    }

    public Map<String, String> inventoryNameParsing(List<String> itemDetails){
        itemDetails = inventoryList;
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

    public int itemStock(String code){
        int count = this.codeToStock.get(code);
        return count;
    }

    public FileReader getInventory() {
        return inventory;
    }

    public Map<String, Double> getCodeToPrice() {
        return codeToPrice;
    }

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
