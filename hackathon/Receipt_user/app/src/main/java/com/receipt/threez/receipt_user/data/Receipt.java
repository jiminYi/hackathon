package com.receipt.threez.receipt_user.data;

import java.util.*;

public class Receipt {
    private String company;
    private String date;
    private String time;
    private String addr;
    private List<Item> items;
    private int totalPrice;
    private String cardNumber;
    private String cardCompany;
    private String approvalNumber;
    private String installment;

    public Receipt(String company, String date, String time, String addr, List<Item> items,
                   String cardNumber, String cardCompany, String approvalNumber, String installment) {
        this.company = company;
        this.date = date;
        this.time = time;
        this.addr = addr;
        this.items = items;
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.approvalNumber = approvalNumber;
        this.installment = installment;
        setTotalPrice();
    }

    private void setTotalPrice() {
        totalPrice = 0;
        for(Item item : items) {
            totalPrice += item.getPrice();
        }
    }

    public String getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddr() {
        return addr;
    }

    public List<Item> getItems() {
        return items;
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

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public String getInstallment() {
        return installment;
    }
}
