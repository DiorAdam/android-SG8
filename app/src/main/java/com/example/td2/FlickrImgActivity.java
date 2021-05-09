package com.example.td2;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class FlickrImgActivity extends Activity {
    ImageView flickr_img;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.flickr_img);
        flickr_img = findViewById(R.id.flickr_img);

        Button get_img = findViewById(R.id.button_get_img);
        get_img.setOnClickListener(ev ->{
            new AsyncFlickrJSONData(this).execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json");
        });

    }
}
