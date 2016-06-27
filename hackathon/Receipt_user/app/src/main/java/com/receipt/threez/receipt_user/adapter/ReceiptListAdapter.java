package com.receipt.threez.receipt_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.receipt.threez.receipt_user.R;
import com.receipt.threez.receipt_user.data.Receipt;

import java.util.*;

public class ReceiptListAdapter extends BaseAdapter {
    private int layout;
    private LayoutInflater inflater;
    List<Receipt> receipts;

    public ReceiptListAdapter(Context context, int layout, List<Receipt> receipts) {
        this.layout = layout;
        this.receipts = receipts;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return receipts.size();
    }

    @Override
    public Object getItem(int position) {
        return receipts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReceiptListHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
            viewHolder = new ReceiptListHolder();
            viewHolder.company = (TextView) convertView.findViewById(R.id.receipt_company);
            viewHolder.date = (TextView) convertView.findViewById(R.id.receipt_date);
            viewHolder.time = (TextView) convertView.findViewById(R.id.receipt_time);
            viewHolder.cardCompany = (TextView) convertView.findViewById(R.id.receipt_card_company);
            viewHolder.totalPrice = (TextView) convertView.findViewById(R.id.receipt_total_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ReceiptListHolder) convertView.getTag();
        }
        final Receipt receipt = receipts.get(position);
        viewHolder.company.setText(receipt.getCompany());
        viewHolder.date.setText(receipt.getDate());
        viewHolder.time.setText(receipt.getTime());
        viewHolder.cardCompany.setText(receipt.getCardCompany());
        receipt.getTotalPrice();
        viewHolder.totalPrice.setText(receipt.getTotalPrice()+"");
        return convertView;
    }

    public class ReceiptListHolder {
        public TextView company;
        public TextView date;
        public TextView time;
        public TextView cardCompany;
        public TextView totalPrice;
    }
}
