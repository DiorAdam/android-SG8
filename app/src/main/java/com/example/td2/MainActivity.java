package com.example.td2;

import android.app.ListActivity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent auth_call = new Intent(getApplicationContext(), Authentication.class);
        startActivity(auth_call);
    }
}
