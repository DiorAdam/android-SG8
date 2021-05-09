package com.example.td2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class FlickrImgActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.flickr_img);

        Button get_img = findViewById(R.id.button_get_img);
        get_img.setOnClickListener(ev ->{
            new AsyncFlickrJSONData().execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json");
        });
    }
}
