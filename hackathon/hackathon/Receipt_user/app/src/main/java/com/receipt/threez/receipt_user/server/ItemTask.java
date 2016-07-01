package com.receipt.threez.receipt_user.server;

import android.os.AsyncTask;
import android.util.Log;

import com.receipt.threez.receipt_user.ReceiptFragment;
import com.receipt.threez.receipt_user.data.Item;
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
import java.util.ArrayList;
import java.util.List;

public class ItemTask extends AsyncTask<String, String, List<Item>> {
    private HttpPost httppost;
    private HttpResponse response;
    private HttpClient httpclient;
    private List<NameValuePair> nameValuePairs;
    private Receipt receipt;

    public ItemTask(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Item> doInBackground(String... params) {
        List<Item> items = null;
        try{
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://jaj7884.cafe24.com/getReceipt.jsp");
            nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("receipt_id", params[0]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            response = httpclient.execute(httppost);
            HttpEntity responseResultEntity=response.getEntity();
            if(responseResultEntity != null) {
                InputStream is = responseResultEntity.getContent();
                BufferedReader reader;
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                items = new ArrayList<Item>();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                    String temp = line.replace("{\"List\":", "[");
                    temp = temp.replace("}}", "}]");
                    Item newItem = getItemObject(temp);
                    if(newItem != null) {
                        items.add(newItem);
                    }
                    Log.d("recetask", "item line=>" + line);
                }
                is.close();
                receipt.setItems(items);
            }
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return items;
    }

    @Override
    protected void onPostExecute(final List<Item> items) {
        super.onPostExecute(items);
        ReceiptFragment.receiptListAdapter.notifyDataSetChanged();
    }

    private Item getItemObject(String string){
        Item item = null;
        Log.d("recetask", "string=>" + string);
        try {
            JSONArray jarray = new JSONArray(string);
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);
                String productName = jObject.getString("product_name");
                String productPrice = jObject.getString("product_price");
                String productCategory = jObject.getString("product_category");
                String productAmount = jObject.getString("product_amount");
                item = new Item(productName, productCategory, Integer.parseInt(productPrice), Integer.parseInt(productAmount));
                Log.d("recetask", "new item=>" + item.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }
}
