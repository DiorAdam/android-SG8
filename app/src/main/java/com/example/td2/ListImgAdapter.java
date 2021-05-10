package com.example.td2;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Vector;

public class ListImgAdapter extends BaseAdapter {
    Vector<String> urls = new Vector<>();

    public void add(String url){
        urls.add(url);
        Log.i("yolo", "Added to adapter url: " + url);
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("yolo", "Logging from ListImgAdapter.getView()");
        return null;
    }
}
