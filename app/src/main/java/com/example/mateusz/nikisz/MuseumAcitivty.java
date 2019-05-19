package com.example.mateusz.nikisz;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.ResourceBundle;

public class MuseumAcitivty extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        TextView museum_textView_topText = findViewById(R.id.museum_textView_topText);
        TextView museumTextViewSmall =  findViewById(R.id.museum_textView_smallText);
        TextView museum_textView_description =  findViewById(R.id.museum_textView_description);
        TextView museum_textView_allText =  findViewById(R.id.museum_textView_allText);
        TextView museum_textView_information =  findViewById(R.id.museum_textView_information);
        TextView museum_textView_localization =  findViewById(R.id.museum_textView_localization);
        TextView museum_textView_localization_place =  findViewById(R.id.museum_textView_localization_place);
        TextView museum_textView_localization_time =  findViewById(R.id.museum_textView_localization_time);


        museum_textView_topText.setText(rb.getString("museum_textView_topText"));
        museumTextViewSmall.setText(rb.getString("museum_textView_small"));
        museum_textView_description.setText(rb.getString("textView_description"));
        museum_textView_allText.setText(rb.getString("museum_textView_allText"));
        museum_textView_information.setText(rb.getString("textView_information"));
        museum_textView_localization.setText(rb.getString("textView_localization"));
        museum_textView_localization_place.setText(rb.getString("textView_localization_place"));
        museum_textView_localization_time.setText(rb.getString("museum_textView_localization_time"));

        Button show_distance = findViewById(R.id.show_distance_button);
        show_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView show_distance_textView = findViewById(R.id.show_distance_textView);
                show_distance_textView.setText(R.string.good);
            }
        });
    }
}
