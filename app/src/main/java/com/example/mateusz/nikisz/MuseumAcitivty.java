package com.example.mateusz.nikisz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ResourceBundle;

public class MuseumAcitivty extends AppCompatActivity {

    private TextView museum_textView_topText;
    private TextView museumTextViewSmall;
    private TextView museum_textView_description;
    private TextView museum_textView_allText;
    private TextView museum_textView_information;
    private TextView museum_textView_localization;
    private TextView museum_textView_localization_place;
    private TextView museum_textView_localization_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        getSupportActionBar().hide();

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        museum_textView_topText = (TextView) findViewById(R.id.museum_textView_topText);
        museumTextViewSmall = (TextView) findViewById(R.id.museum_textView_smallText);
        museum_textView_description = (TextView) findViewById(R.id.museum_textView_description);
        museum_textView_allText = (TextView) findViewById(R.id.museum_textView_allText);
        museum_textView_information = (TextView) findViewById(R.id.museum_textView_information);
        museum_textView_localization = (TextView) findViewById(R.id.museum_textView_localization);
        museum_textView_localization_place = (TextView) findViewById(R.id.museum_textView_localization_place);
        museum_textView_localization_time = (TextView) findViewById(R.id.museum_textView_localization_time);

        museum_textView_topText.setText(rb.getString("museum_textView_topText"));
        museumTextViewSmall.setText(rb.getString("museum_textView_small"));
        museum_textView_description.setText(rb.getString("textView_description"));
        museum_textView_allText.setText(rb.getString("museum_textView_allText"));
        museum_textView_information.setText(rb.getString("textView_information"));
        museum_textView_localization.setText(rb.getString("textView_localization"));
        museum_textView_localization_place.setText(rb.getString("textView_localization_place"));
        museum_textView_localization_time.setText(rb.getString("museum_textView_localization_time"));
    }
}
