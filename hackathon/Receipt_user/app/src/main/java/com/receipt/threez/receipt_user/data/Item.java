package com.receipt.threez.receipt_user.data;

public class Item {
    private String name;
    private String category;
    private int unitPrice;
    private int amount;
    private int price;

    public Item(String name, String category, int unitPrice, int amount) {
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.price = unitPrice * amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
