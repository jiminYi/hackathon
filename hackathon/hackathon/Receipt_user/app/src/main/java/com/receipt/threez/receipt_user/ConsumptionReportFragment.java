package com.receipt.threez.receipt_user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConsumptionReportFragment extends Fragment {

    public ConsumptionReportFragment() {

    }

    public static ConsumptionReportFragment newInstance() {
        ConsumptionReportFragment fragment = new ConsumptionReportFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consumption_report, container, false);
        return view;
    }
}
