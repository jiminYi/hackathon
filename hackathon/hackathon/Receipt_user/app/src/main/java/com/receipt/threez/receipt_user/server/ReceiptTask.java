package com.receipt.threez.receipt_user.server;

import android.os.AsyncTask;
import android.util.Log;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ReceiptTask extends AsyncTask<String, String, List<Receipt>> {
    private HttpPost httppost;
    private HttpResponse response;
    private HttpClient httpclient;
    private List<NameValuePair> nameValuePairs;

    public ReceiptTask() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Receipt> doInBackground(String... params) {
        List<Receipt> receipts = null;
        try{
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://jaj7884.cafe24.com/getNFC.jsp");
            nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("nfc_id", params[0]));
            Log.d("recetask", "param=>" + params[0]);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            Log.d("recetask", "param0=>" + params[0]);
            response = httpclient.execute(httppost);
            HttpEntity responseResultEntity=response.getEntity();
            Log.d("recetask", "param1=>" + params[0]);
            if(responseResultEntity != null) {
                Log.d("recetask", "param2=>" + params[0]);
                InputStream is = responseResultEntity.getContent();
                BufferedReader reader;
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                ReceiptFragment.receipts.clear();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("recetask", "line=>" + line);
                    String temp = line.replace("{\"List\":", "[");
                    temp = temp.replace("}}", "}]");
                    Receipt newReceipt = getReceiptObject(temp);
                    if(newReceipt != null) {
                        ReceiptFragment.receipts.add(newReceipt);
                    }
                }
                is.close();
                receipts = ReceiptFragment.receipts;
                Log.d("recetask", "size=>" + receipts.size());
            }
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return receipts;
    }

    @Override
    protected void onPostExecute(final List<Receipt> receipts) {
        super.onPostExecute(receipts);
        ReceiptFragment.receiptListAdapter.notifyDataSetChanged();
        for(Receipt receipt : receipts) {
            new ItemTask(receipt).execute(receipt.getId());
        }
    }

    private Receipt getReceiptObject(String string){
        Receipt receipt = null;
        Log.d("recetask", "string=>" + string);
        try {
            JSONArray jarray = new JSONArray(string);
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);
                String receiptID = jObject.getString("receipt_id");
                String storeName = jObject.getString("store_name");
                String storeAddr = jObject.getString("store_addr");
                String cardNumber = jObject.getString("card_number");
                String cardCompany = jObject.getString("card_company");
                String date = jObject.getString("purchase_date");
                receipt = new Receipt(receiptID, storeName, storeAddr, cardNumber, cardCompany, date);
                Log.d("recetask", "new receipt=>" + receipt.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return receipt;
    }
}