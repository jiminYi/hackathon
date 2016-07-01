package com.receipt.threez.receipt_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.*;

import com.receipt.threez.receipt_user.data.Item;
import com.receipt.threez.receipt_user.data.Receipt;

public class ReceiptDetailActivity extends AppCompatActivity {
    private int position;
    private Receipt receipt;
    private TextView company;
    private TextView addr;
    private TextView date;
    private TextView time;
    private TextView totalPrice;
    private TextView cardNumber;
    private TextView cardCompany;
    private TableLayout itemTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        company = (TextView) findViewById(R.id.receipt_detail_company);
        addr = (TextView) findViewById(R.id.receipt_detail_addr);
        date = (TextView) findViewById(R.id.receipt_detail_date);
        totalPrice = (TextView) findViewById(R.id.receipt_detail_total_price);
        cardNumber = (TextView) findViewById(R.id.receipt_detail_card_number);
        cardCompany = (TextView) findViewById(R.id.receipt_detail_card_company);
        itemTable = (TableLayout) findViewById(R.id.receipt_detail_table_item);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        if(position != -1) {
            receipt = ReceiptFragment.receipts.get(position);
            setReceiptDetail();
        }
    }

    private void setReceiptDetail() {
        company.setText(receipt.getStoreName());
        addr.setText(receipt.getStoreAddr());
        date.setText(receipt.getDate());
        totalPrice.setText(receipt.getTotalPrice() + "");
        cardNumber.setText(receipt.getCardNumber());
        cardCompany.setText(receipt.getCardCompany());
        setItems();
    }

    private void setItems() {
        for(Item item : receipt.getItems()) {
            addRow(item.getProductName(), item.getProductPrice() + "", item.getAmount() + "", item.getPrice() + "");
        }
    }

    private void addRow(String name, String unitPrice, String amount, String price) {
        TableRow tr = new TableRow(this);
        addTextViewOnRow(tr, name);
        addTextViewOnRow(tr, unitPrice);
        addTextViewOnRow(tr, amount);
        addTextViewOnRow(tr, price);

        TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(tableRowParams);
        itemTable.addView(tr, tableRowParams);
    }

    private void addTextViewOnRow(TableRow tr, String text) {
        int leftMargin=0;
        int topMargin=2;
        int rightMargin=0;
        int bottomMargin=2;

        TextView tvName = new TextView(this);
        tvName.setText(text);
        tvName.setPadding(15, 20, 15, 20);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
        tvName.setLayoutParams(layoutParams);
        tr.addView(tvName);

    }
}
