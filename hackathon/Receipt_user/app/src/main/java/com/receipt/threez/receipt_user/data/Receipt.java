package com.receipt.threez.receipt_user.data;

import java.util.*;

public class Receipt {
    private String storeName;
    private String storeAddr;
    private String cardNumber;
    private String cardCompany;
    private String date;
    private String time;
    private List<Item> items;
    private int totalPrice;

    public Receipt(String storeName, String storeAddr,  String cardNumber, String cardCompany,
                   String date, String time, List<Item> items) {
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.date = date;
        this.time = time;
        this.items = items;
        setTotalPrice();
    }

    public Receipt(String storeName, String storeAddr,  String cardNumber, String cardCompany,
                   String date, String time) {
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.date = date;
        this.time = time;
        setTotalPrice();
    }

    private void setTotalPrice() {
        totalPrice = 0;
        for(Item item : items) {
            totalPrice += item.getPrice();
        }
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardCompany() {
        return cardCompany;
    }
}
