package com.example.td2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

public class FlickrImgListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_flickr_img_list);

        this.launchFlickrRequest();
    }

    private void launchFlickrRequest(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String defaultValue = "stars";
        String imgCategory = sp.getString("img-category", defaultValue);

        ListImgAdapter adapter = new ListImgAdapter(this);
        ListView list_img = findViewById(R.id.list_img);
        list_img.setAdapter(adapter);
        new AsyncFlickrJSONDataForList(adapter).execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=" +
                imgCategory +
                "&format=json");
    }
}
