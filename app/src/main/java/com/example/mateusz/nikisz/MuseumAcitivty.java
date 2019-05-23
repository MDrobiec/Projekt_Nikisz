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

public class MuseumAcitivty extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button show_distance;
    private TextView show_distance_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        TextView museum_textView_topText = findViewById(R.id.museum_textView_topText);
        TextView museumTextViewSmall = findViewById(R.id.museum_textView_smallText);
        TextView museum_textView_description = findViewById(R.id.museum_textView_description);
        TextView museum_textView_allText = findViewById(R.id.museum_textView_allText);
        TextView museum_textView_information = findViewById(R.id.museum_textView_information);
        TextView museum_textView_localization = findViewById(R.id.museum_textView_localization);
        TextView museum_textView_localization_place = findViewById(R.id.museum_textView_localization_place);
        TextView museum_textView_localization_time = findViewById(R.id.museum_textView_localization_time);
        show_distance = findViewById(R.id.show_distance_button);
        show_distance_textView = findViewById(R.id.show_distance_textView);

        museum_textView_topText.setText(rb.getString("museum_textView_topText"));
        museumTextViewSmall.setText(rb.getString("museum_textView_small"));
        museum_textView_description.setText(rb.getString("textView_description"));
        museum_textView_allText.setText(rb.getString("museum_textView_allText"));
        museum_textView_information.setText(rb.getString("textView_information"));
        museum_textView_localization.setText(rb.getString("textView_localization"));
        museum_textView_localization_place.setText(rb.getString("textView_localization_place"));
        museum_textView_localization_time.setText(rb.getString("museum_textView_localization_time"));


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                show_distance_textView.append("\n "+location.getLatitude()+" "+location.getLongitude());
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