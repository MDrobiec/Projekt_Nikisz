package com.example.mateusz.nikisz;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.ResourceBundle;

public class TechnicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        ResourceBundle rb = ResourceBundle.getBundle("textnikisz");

        TextView technical_textView_top = findViewById(R.id.technical_textView_top);
        TextView technical_textView_small = findViewById(R.id.technical_textView_small);
        TextView technical_textView_small_info = findViewById(R.id.technical_textView_small_info);
        TextView technical_textView_estateNikiszowiec = findViewById(R.id.technical_textView_estateNikiszowiec);
        TextView technical_textView_nameOfWilson = findViewById(R.id.technical_textView_wilson);

        technical_textView_top.setText(rb.getString("technical_textView_top"));
        technical_textView_small.setText(rb.getString("technical_textView_small"));
        technical_textView_small_info.setText(rb.getString("technical_textView_small_info"));
        technical_textView_estateNikiszowiec.setText(rb.getString("technical_textView_nameOfEstate"));
        technical_textView_nameOfWilson.setText(rb.getString("technical_textView_nameOfWilson"));

    }
}
