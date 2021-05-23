package com.example.td2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.util.Log;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity /*implements LocationListener*/ {
    LocationManager lm;
    double lat = 0, lng = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setButtonListeners();

        /*
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if ( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions( new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            Log.i("position0", "lat:" + lat + "   lng:" + lng + "\n");
        }
         */
    }

    private void setButtonListeners() {
        Button bob_act = findViewById(R.id.button_bob);
        bob_act.setOnClickListener(ev -> {
            Intent to_auth = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(to_auth);
        });

        Button flickr_img_act = findViewById(R.id.button_flickr_img);
        flickr_img_act.setOnClickListener(ev -> {
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

    /*
    @Override
    public void onLocationChanged(@NonNull Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
        Log.i("position1", "lat:" + lat + "   lng:" + lng + "\n");
    }

    @Override
    public void onProviderDisabled(String s){
        Log.i("position", "GPS has been disabled");
    }

    @Override
    public void onProviderEnabled(String s){
        Log.i("position", "GPS has been enabled");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            Log.i("position0", "lat:" + lat + "   lng:" + lng + "\n");
        }
    }
    */
}
