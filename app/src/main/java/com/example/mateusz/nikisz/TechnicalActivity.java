package com.example.mateusz.nikisz;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.ResourceBundle;

public class TechnicalActivity extends AppCompatActivity {

    private double szerkosc_wieczorek = 50.239472279997955;
    private double wysokosc_wieczorek = 19.078173090139757;

    private double szerokosc_nikiszowiec = 50.24371764381374;
    private double wysokosc_nikiszowiec = 19.082176172029676;

    private double szerokosc_wilson = 50.25040015025496;
    private double wysokosc_wilson = 19.08356591110183;

    private double szerokosc_giszowiec = 50.223932382798324;
    private double wysokosc_giszowiec = 19.06313894798032;

    private double szerokosc_porcelana = 50.25345033810191;
    private double wysokosc_porcelana = 19.06083789574626;

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
        TextView technical_textView_nameOfWieczorek = findViewById(R.id.technical_textView_wieczorek);
        TextView technical_textView_nameOfGiszowiec = findViewById(R.id.technical_textView_giszowiec);
        TextView technical_textView_nameOfPorcelana = findViewById(R.id.technical_textView_porcelana);

        technical_textView_top.setText(rb.getString("technical_textView_top"));
        technical_textView_small.setText(rb.getString("technical_textView_small"));
        technical_textView_small_info.setText(rb.getString("technical_textView_small_info"));
        technical_textView_estateNikiszowiec.setText(rb.getString("technical_textView_nameOfEstate"));
        technical_textView_nameOfWilson.setText(rb.getString("technical_textView_nameOfWilson"));
        technical_textView_nameOfGiszowiec.setText(rb.getString("technical_textView_nameOfGiszowiec"));
        technical_textView_nameOfPorcelana.setText(rb.getString("technical_textView_nameOfPorcelana"));
        technical_textView_nameOfWieczorek.setText(rb.getString("technical_textView_nameOfWieczorek"));

    }
}
