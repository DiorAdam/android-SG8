package com.example.td2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;

public class FlickrImgActivity extends Activity {
    ImageView flickr_img;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_flickr_img);
        flickr_img = findViewById(R.id.flickr_img);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String imgCategory = sp.getString("img-category", "trees");
        Button get_img = findViewById(R.id.button_get_img);
        get_img.setOnClickListener(ev ->{
            new AsyncFlickrJSONData(this).execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=" +
                    imgCategory +
                    "&format=json");
        });
    }
}
