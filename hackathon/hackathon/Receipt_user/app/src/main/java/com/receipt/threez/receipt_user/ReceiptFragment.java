package com.receipt.threez.receipt_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.receipt.threez.receipt_user.adapter.ReceiptListAdapter;
import com.receipt.threez.receipt_user.data.Item;
import com.receipt.threez.receipt_user.data.Receipt;
import com.receipt.threez.receipt_user.server.ItemTask;
import com.receipt.threez.receipt_user.server.ReceiptTask;

import java.util.*;

public class ReceiptFragment extends Fragment {
    final public static String nfcID = "test_nfc_id";
    public static List<Receipt> receipts = new ArrayList<Receipt>();
    public static ReceiptListAdapter receiptListAdapter;
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
        setReceiptListAdapter();
        getReceiptInfo();
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

    private void setReceiptListAdapter() {
        receiptListAdapter = new ReceiptListAdapter(getActivity(), R.layout.list_receipt, receipts);
        listReceipts.setAdapter(receiptListAdapter);
    }

    public static void getReceiptInfo() {
        receipts.clear();
        new ReceiptTask().execute("2222");
    }
}
