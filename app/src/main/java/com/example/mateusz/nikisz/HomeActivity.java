package com.example.mateusz.nikisz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ResourceBundle;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button home_button_turistAtraction;
    private Button home_button_turistInformation;
    private Button home_button_museum;
    private Button home_button_monumentialTrail;
    private Button home_button_sportsEvent;
    private Button home_button_history;
    private Button home_button_maps;
    private Button home_button_turistTrail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        home_button_turistAtraction = (Button) findViewById(R.id.home_button_turistAtraction);
        home_button_turistInformation = (Button) findViewById(R.id.home_button_turistInformation);
        home_button_museum = (Button) findViewById(R.id.home_button_museum);
        home_button_monumentialTrail = (Button) findViewById(R.id.home_button_monumentialTrail);
        home_button_sportsEvent = (Button) findViewById(R.id.home_button_sportsEvent);
        home_button_history = (Button) findViewById(R.id.home_button_history);
        home_button_maps = (Button) findViewById(R.id.home_button_maps);
        home_button_turistTrail = (Button) findViewById(R.id.home_button_turistTrail);

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
            case R.id.home_button_maps:
                open_activity_maps();
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
    public void open_activity_maps(){
        Intent intent = new Intent(this,MapsActivity.class);
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
