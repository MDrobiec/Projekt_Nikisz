package com.example.mateusz.nikisz;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Objects;
import java.util.ResourceBundle;

public class MuseumAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

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

        Button show_maps = findViewById(R.id.explore_to_maps);
        show_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:50.24413278280385,19.082070471118612?q=Rymarska 4");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                finish();
            }
        });

        Button show_fb = findViewById(R.id.explore_to_fb);
        show_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookId = "fb://page/<Facebook Page ID>";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)));
                finish();
            }
        });

        Button show_side = findViewById(R.id.explore_to_side);
        show_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explore_to_side = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zabytkitechniki.pl/Poi/Pokaz/1607/17/punkt-informacji-turystycznej-w-katowicach-nikiszo"));
                startActivity(explore_to_side);
                finish();
            }
        });

        Button show = findViewById(R.id.explore);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
