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

        Button bob_act = findViewById(R.id.button_bob);
        bob_act.setOnClickListener( ev -> {
            Intent auth_call = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(auth_call);
        });

        Button flickr_img__act = findViewById(R.id.button_flickr_img);
        flickr_img__act.setOnClickListener( ev -> {
            Intent flickr_call = new Intent(getApplicationContext(), FlickrImgActivity.class);
            startActivity(flickr_call);
        });
    }
}
