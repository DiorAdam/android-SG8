package com.example.td2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;

import java.util.Vector;

public class ListImgAdapter extends BaseAdapter {
    Vector<String> urls = new Vector<>();
    Context context;

    public ListImgAdapter(Context context_){
        this.context = context_;
    }

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
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("yolo", "Logging from ListImgAdapter.getView()");
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                            .inflate(R.layout.img_url_textview, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.textview_img_url);
        tv.setText(urls.get(position));
        return convertView;
    }
}


