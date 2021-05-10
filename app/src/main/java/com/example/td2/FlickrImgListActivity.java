package com.example.td2;

import android.app.Activity;
import android.os.Bundle;

public class FlickrImgListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.flickr_img_list);

        new AsyncFlickrJSONDataForList(new ListImgAdapter()).execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json");
    }
}
