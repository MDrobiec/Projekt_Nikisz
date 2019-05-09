package com.example.mateusz.nikisz;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ResourceBundle;

public class InfoActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;

    private double value1szer =  50.24413278280385;
    private double value1dl =  19.082070471118612;
    private double factor = 1e4;

    private TextView info_textView_topText;
    private TextView info_TextView_small;
    private TextView info_textView_description;
    private TextView info_textView_allText;
    private TextView info_textView_information;
    private TextView info_textView_localization;
    private TextView info_textView_localization_place;
    private TextView info_textView_localization_time;
    private TextView info_textView_distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        info_textView_topText = (TextView) findViewById(R.id.info_textView_top);
        info_TextView_small = (TextView) findViewById(R.id.info_textView_small);
        info_textView_description = (TextView) findViewById(R.id.info_textView_description);
        info_textView_allText = (TextView) findViewById(R.id.info_textView_allText);
        info_textView_information = (TextView) findViewById(R.id.info_textView_information);
        info_textView_localization = (TextView) findViewById(R.id.info_textView_localization);
        info_textView_localization_place = (TextView) findViewById(R.id.info_textView_localization_place);
        info_textView_localization_time = (TextView) findViewById(R.id.info_textView_localization_time);
        info_textView_distance = (TextView) findViewById(R.id.info_textView_distance);

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
                location.getLatitude();
                location.getLongitude();
                String text = "Odległość wynosi: " +  (Math.round(Math.sqrt((Math.pow(value1szer-location.getLatitude(),2)+(Math.pow(value1dl-location.getLongitude(),2)))*73)*factor) / factor)*10 + " km";
                info_textView_distance.setText(text);
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            @Override
            public void onProviderEnabled(String provider) {}
            @Override
            public void onProviderDisabled(String provider) {}
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
}