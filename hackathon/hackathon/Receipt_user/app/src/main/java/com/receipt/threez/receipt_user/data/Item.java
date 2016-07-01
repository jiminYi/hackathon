package com.receipt.threez.receipt_user.data;

public class Item {
    private String productName;
    private int productPrice;
    private String productCategory;
    private int amount;
    private int price;

    public Item(String productName, String productCategory, int productPrice, int amount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.amount = amount;
        this.price = productPrice * amount;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
