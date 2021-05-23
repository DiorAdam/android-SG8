package com.example.td2;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncFlickrJSONData extends AsyncTask<String, Void, JSONObject> {
    @SuppressLint("StaticFieldLeak")
    FlickrImgActivity flickrAct;

    public AsyncFlickrJSONData(FlickrImgActivity flickrAct_){
        this.flickrAct = flickrAct_;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        URL url;
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
            String img_url = result.getJSONArray("items").getJSONObject(1).getJSONObject("media").getString("m");
            Log.i("yolo", "img url: " + img_url);
            new AsyncBitmapDownloader(flickrAct).execute(img_url);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


