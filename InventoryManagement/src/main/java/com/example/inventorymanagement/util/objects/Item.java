package com.example.inventorymanagement.util.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Item implements Serializable {
    private String itemName;
    private int itemId;
    private int totalQty;
    private LinkedList<Stock> stocks = new LinkedList<>();

    public Item(){
        itemName = null;
        itemId = -1;
        totalQty = 0;
    }

    /**
     * Constructor for item object
     * @param itemName      Name of the Item
     * @param itemId        Id of the item generated by the backend of server
     * @param totalQty      totalQty tallied by the backend
     * @param stocks        LinkedHashMap of Stocks with the batchNo as the Key and object of Stock as the Value
     */
    public Item(String itemName, int itemId, int totalQty, LinkedList<Stock> stocks) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.totalQty = totalQty;
        this.stocks = stocks;
    }

    /**
     * This adds an object of stock into the linkedhashmap named stocks
     * @param batchNo   String of batchNo, format: <supplierName_date_cost>
     * @param stock     Object of stock
     */
    public void addStocks(String batchNo, Stock stock){
        stocks.add(stock);
    }

    /**
     * This method returns an object of stock stored in the linkedhashmap given the batchNo
     * of the stock
     * @param batchNo   String of batchNo, format: <supplierName_date_cost>
     * @return
     */
    public Stock getStock(String batchNo){
        for(Stock stock: stocks){
            if(stock.getBatchNo().equals(batchNo)){
                return stock;
            }
        }
        return null;
    }

    //Getter and setters below

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public LinkedList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(LinkedList<Stock> stocks) {
        this.stocks = stocks;
    }
}
