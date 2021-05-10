package com.example.td2;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class AsyncFlickrJSONDataForList extends AsyncTask<String, Void, JSONObject> {
    ListImgAdapter adapter;

    public AsyncFlickrJSONDataForList(ListImgAdapter adapter_){
        this.adapter = adapter_;
    }


    @Override
    protected JSONObject doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String s = AuthActivity.readStream(in);
                s = s.substring(15, s.length()-1); //Remove jsonFlickrFeed()
                return new JSONObject(s);
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(JSONObject result){
        try {
            JSONArray items = result.getJSONArray("items");
            String img_url;
            for (int i=0; i<items.length(); i++){
                img_url = items.getJSONObject(i).getJSONObject("media").getString("m");
                this.adapter.add(img_url);
            }
            adapter.notifyDataSetChanged();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
