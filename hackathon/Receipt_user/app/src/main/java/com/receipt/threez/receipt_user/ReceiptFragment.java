package com.receipt.threez.receipt_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.receipt.threez.receipt_user.adapter.ReceiptListAdapter;
import com.receipt.threez.receipt_user.data.Item;
import com.receipt.threez.receipt_user.data.Receipt;

import java.util.*;

public class ReceiptFragment extends Fragment {
    public static List<Receipt> receipts = new ArrayList<Receipt>();
    private static ReceiptListAdapter receiptListAdapter;
    private ListView listReceipts;

    public ReceiptFragment() {
    }

    public static ReceiptFragment newInstance() {
        ReceiptFragment fragment = new ReceiptFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);
        listReceipts = (ListView) view.findViewById(R.id.lv_receipt);
        getReceiptInfo();
        setReceiptList();
        listReceipts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ReceiptDetailActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        return view;
    }

    private static void getReceiptInfo() {
        receipts.clear();
        /*test*/
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("떡볶이", "분식", 3000, 1));
        receipts.add(new Receipt("달복이", "2016/06/27", "18:17:57", "서울특별시 용산구 청파로47길 88", items, "5107-****-****-****", "신한카드", "123456", "일시불"));
        /*test*/
    }

    private void setReceiptList() {
        receiptListAdapter = new ReceiptListAdapter(getActivity(), R.layout.list_receipt, receipts);
        listReceipts.setAdapter(receiptListAdapter);
    }

    public static void refreshReceiptList() {
        getReceiptInfo();
        receiptListAdapter.notifyDataSetChanged();
    }
}
