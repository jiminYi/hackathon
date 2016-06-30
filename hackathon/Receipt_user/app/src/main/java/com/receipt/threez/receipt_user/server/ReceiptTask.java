package com.receipt.threez.receipt_user.server;

import android.os.AsyncTask;

import com.receipt.threez.receipt_user.ReceiptFragment;
import com.receipt.threez.receipt_user.data.Receipt;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ReceiptTask extends AsyncTask<String, String, List<Receipt>> {
    private HttpPost httppost;
    private HttpResponse response;
    private HttpClient httpclient;
    private List<NameValuePair> nameValuePairs;

    ReceiptTask() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Receipt> doInBackground(String... params) {
        List<Receipt> receipts = null;
        String result;
        try{
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("#");
            nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("nfc_id", params[0]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            response = httpclient.execute(httppost);
            HttpEntity responseResultEntity=response.getEntity();
            if(responseResultEntity != null) {
                InputStream is = responseResultEntity.getContent();
                BufferedReader reader;
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                receipts = new ArrayList<Receipt>();
                ReceiptFragment.receipts = receipts;
            }
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return receipts;
    }

    @Override
    protected void onPostExecute(final List<Receipt> receipts) {
        super.onPostExecute(receipts);
    }
}