package com.receipt.threez.receipt_user.server;

import android.os.AsyncTask;

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

    ItemTask() {

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Item> doInBackground(String... params) {
        List<Item> items = null;
        String result;
        try{
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("#");
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
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                items = new ArrayList<Item>();
            }
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return items;
    }

    @Override
    protected void onPostExecute(final List<Item> items) {
        super.onPostExecute(items);
    }
}
