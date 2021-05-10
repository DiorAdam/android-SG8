package com.example.td2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FlickrImgListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.flickr_img_list);

        ListImgAdapter adapter = new ListImgAdapter(this);
        ListView list_img = findViewById(R.id.list_img);
        list_img.setAdapter(adapter);
        new AsyncFlickrJSONDataForList(adapter).execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json");
    }
}
