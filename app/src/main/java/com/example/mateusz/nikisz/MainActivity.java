package com.example.mateusz.nikisz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.process_bar);
        textView = findViewById(R.id.main_bottom_textview_numberPercent);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();

    }

    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar,textView,0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }
}
