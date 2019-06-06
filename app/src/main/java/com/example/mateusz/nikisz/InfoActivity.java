package com.example.mateusz.nikisz;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.ResourceBundle;

public class InfoActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button show_distance;
    private double value1szer =  50.24413278280385;
    private double value1dl =  19.082070471118612;
    private double factor = 1e4;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        TextView info_textView_topText = findViewById(R.id.info_textView_top);
        TextView info_TextView_small = findViewById(R.id.info_textView_small);
        TextView info_textView_description = findViewById(R.id.info_textView_description);
        TextView info_textView_allText = findViewById(R.id.info_textView_allText);
        TextView info_textView_information = findViewById(R.id.info_textView_information);
        TextView info_textView_localization = findViewById(R.id.info_textView_localization);
        TextView info_textView_localization_place = findViewById(R.id.info_textView_localization_place);
        TextView info_textView_localization_time = findViewById(R.id.info_textView_localization_time);
        show_distance = findViewById(R.id.show_distance_button_info);

        info_textView_topText.setText(rb.getString("info_textView_topText"));
        info_TextView_small.setText(rb.getString("info_textView_small"));
        info_textView_description.setText(rb.getString("textView_description"));
        info_textView_allText.setText(rb.getString("info_textView_allText"));
        info_textView_information.setText(rb.getString("textView_information"));
        info_textView_localization.setText(rb.getString("textView_localization"));
        info_textView_localization_place.setText(rb.getString("textView_localization_place"));
        info_textView_localization_time.setText(rb.getString("info_textView_localization_time"));

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String text = ("Odległość wynosi: " +(Math.round(Math.sqrt((Math.pow(value1szer-location.getLatitude(),2)+(Math.pow(value1dl-location.getLongitude(),2)))*73)*factor) / factor)*10 + " km");
                show_distance.setText(text);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                },10);
            }
            return;
        }else{
            button_start();
        }

        Button show_maps = findViewById(R.id.explore_to_maps);
        show_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri gmmIntentUri = Uri.parse("geo:50.24413278280385,19.082070471118612?q=Rymarska 4");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }catch(Exception e){
                    e.printStackTrace();
                    Log.e("Exception","Exception"+e);
                    finish();
                }
            }
        });

        Button show_fb = findViewById(R.id.explore_to_fb);
        show_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String facebookId = "fb://page/111373052221490";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)));
                }catch(Exception e){
                    e.printStackTrace();
                    Log.e("Exception","Exception"+e);
                    finish();
                }
            }
        });

        Button show_side = findViewById(R.id.explore_to_side);
        show_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent explore_to_side = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zabytkitechniki.pl/Poi/Pokaz/1607/17/punkt-informacji-turystycznej-w-katowicach-nikiszo"));
                    startActivity(explore_to_side);
                }catch(Exception e){
                    e.printStackTrace();
                    Log.e("Exception","Exception"+e);
                    finish();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 10) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                button_start();
        }
    }

    private void button_start(){
        show_distance.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });
    }
}