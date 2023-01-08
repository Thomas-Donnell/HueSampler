package com.example.huesampler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.splashscreen.SplashScreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ConstraintLayout backgroundColor;
    ImageButton backBtn2;
    TextView colorHexVal;
    TextView colorRgbVal;
    String hexVal;
    int rgb;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        backgroundColor = findViewById(R.id.backgroundColor);
        backBtn2 = findViewById(R.id.backBtn2);
        colorHexVal = findViewById(R.id.colorHexVal);
        colorRgbVal = findViewById(R.id.colorRgbVal);

        Intent intent = getIntent();
        hexVal = intent.getStringExtra("color");
        colorHexVal.setText("HEX: "+hexVal);
        rgb = Color.parseColor(hexVal);
        int r = Color.red(rgb);
        int g = Color.green(rgb);
        int b = Color.blue(rgb);
        colorRgbVal.setText("R: " + r + " " + "G: " + g + " " + "B: " + b);
        backgroundColor.setBackgroundColor(rgb);

        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}