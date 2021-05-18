package com.example.td2;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setButtonListeners();
    }

    private void setButtonListeners(){
        Button bob_act = findViewById(R.id.button_bob);
        bob_act.setOnClickListener( ev -> {
            Intent to_auth = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(to_auth);
        });

        Button flickr_img_act = findViewById(R.id.button_flickr_img);
        flickr_img_act.setOnClickListener( ev -> {
            Intent to_flickr_img = new Intent(getApplicationContext(), FlickrImgActivity.class);
            startActivity(to_flickr_img);
        });

        Button flickr_img_list_act = findViewById(R.id.button_flickr_img_list);
        flickr_img_list_act.setOnClickListener(ev -> {
            Intent to_flickr_img_list = new Intent(getApplicationContext(), FlickrImgListActivity.class);
            startActivity(to_flickr_img_list);
        });

        Button settings = findViewById(R.id.button_settings);
        settings.setOnClickListener(ev -> {
            Intent to_settings = new Intent(getApplicationContext(), ImgPreferenceActivity.class);
            startActivity(to_settings);
        });
    }
}
