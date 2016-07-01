package com.receipt.threez.receipt_user.data;

import java.util.*;

public class Receipt {
    private String id;
    private String storeName;
    private String storeAddr;
    private String cardNumber;
    private String cardCompany;
    private String date;
    private List<Item> items;
    private int totalPrice;

    public Receipt(String id, String storeName, String storeAddr,  String cardNumber, String cardCompany,
                   String date, List<Item> items) {
        this.id = id;
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.date = date;
        this.items = items;
        setTotalPrice();
    }

    public Receipt(String id, String storeName, String storeAddr,  String cardNumber, String cardCompany,
                   String date) {
        this.id = id;
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.date = date;
    }

    private void setTotalPrice() {
        totalPrice = 0;
        for(Item item : items) {
            totalPrice += item.getPrice();
        }
    }

    public String getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDate() {
        return date;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        setTotalPrice();
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

    @Override
    public String toString() {
        return "Receipt{" +
                "id='" + id + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddr='" + storeAddr + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardCompany='" + cardCompany + '\'' +
                ", date='" + date + '\'' +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
