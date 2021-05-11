package com.example.td2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncBitmapDownloader extends AsyncTask<String, Void, Bitmap> {
    @SuppressLint("StaticFieldLeak")
    FlickrImgActivity flickrAct;


    public AsyncBitmapDownloader(FlickrImgActivity flickrAct_){
        this.flickrAct = flickrAct_;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                return BitmapFactory.decodeStream(in);
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bm){
        Log.i("yolo", "we're in onPostExecute of AsyncBitmap");
        flickrAct.flickr_img.setImageBitmap(bm);
    }
}
