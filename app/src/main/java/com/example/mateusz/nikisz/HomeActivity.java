package com.example.mateusz.nikisz;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Objects;
import java.util.ResourceBundle;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        Button home_button_turistAtraction = findViewById(R.id.home_button_turistAtraction);
        Button home_button_turistInformation =  findViewById(R.id.home_button_turistInformation);
        Button home_button_museum = findViewById(R.id.home_button_museum);
        Button home_button_monumentialTrail = findViewById(R.id.home_button_monumentialTrail);
        Button home_button_sportsEvent = findViewById(R.id.home_button_sportsEvent);
        Button home_button_history = findViewById(R.id.home_button_history);
        Button home_button_maps = findViewById(R.id.home_button_maps);
        Button home_button_turistTrail = findViewById(R.id.home_button_turistTrail);

        home_button_turistAtraction.setText(rb.getString("home_button_textView_turistAtraction"));
        home_button_turistInformation.setText(rb.getString("home_button_textView_turistInformation"));
        home_button_museum.setText(rb.getString("home_button_textView_museum"));
        home_button_monumentialTrail.setText(rb.getString("home_button_textView_monumentialTrail"));
        home_button_sportsEvent.setText(rb.getString("home_button_textView_sportsEvent"));
        home_button_history.setText(rb.getString("home_button_textView_history"));
        home_button_maps.setText(rb.getString("home_button_textView_maps"));
        home_button_turistTrail.setText(rb.getString("home_button_textView_turistTrail"));

        home_button_turistAtraction.setOnClickListener(this);
        home_button_turistInformation.setOnClickListener(this);
        home_button_museum.setOnClickListener(this);
        home_button_monumentialTrail.setOnClickListener(this);
        home_button_sportsEvent.setOnClickListener(this);
        home_button_history.setOnClickListener(this);
        home_button_maps.setOnClickListener(this);
        home_button_turistTrail.setOnClickListener(this);

        home_button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri gmmIntentUri = Uri.parse("geo:50.24413278280385,19.082070471118612");
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
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_button_turistAtraction:
                open_activity_atraction();
                break;
            case R.id.home_button_history:
                open_activity_history();
                break;
            case R.id.home_button_museum:
                open_activity_museum();
                break;
            case R.id.home_button_sportsEvent:
                open_activity_event();
                break;
            case R.id.home_button_monumentialTrail:
                open_activity_technical();
                break;
            case R.id.home_button_turistInformation:
                open_activity_turist_information();
                break;
            case R.id.home_button_turistTrail:
                open_activity_trial();
                break;
        }
    }
    public void open_activity_atraction(){
        Intent intent = new Intent(this,AtractionActivity.class);
        startActivity(intent);
    }
    public void open_activity_turist_information(){
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }
    public void open_activity_event(){
        Intent intent = new Intent(this,EventActivity.class);
        startActivity(intent);
    }
    public void open_activity_history(){
        Intent intent = new Intent(this,HistoryActivity.class);
        startActivity(intent);
    }
    public void open_activity_museum(){
        Intent intent = new Intent(this,MuseumAcitivty.class);
        startActivity(intent);
    }
    public void open_activity_technical(){
        Intent intent = new Intent(this,TechnicalActivity.class);
        startActivity(intent);
    }
    public void open_activity_trial(){
        Intent intent = new Intent(this,TrialActivity.class);
        startActivity(intent);
    }
}
