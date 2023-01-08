package com.example.huesampler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    TextView textView, color, hex;
    ImageButton backBtn;
    Bitmap bitmap;
    MyCanvas canvas;
    String hexVal = "";

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        hex = findViewById(R.id.hex);
        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        color = findViewById(R.id.color);
        backBtn = findViewById(R.id.backBtn);
        canvas = (MyCanvas)findViewById(R.id.myView);

        Uri imageUri=getIntent().getData();
        imageView.setImageURI(imageUri);
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        int pixel = bitmap.getPixel(bitmap.getWidth()/2,bitmap.getHeight()/2);

        int r = Color.red(pixel);
        int g = Color.green(pixel);
        int b = Color.blue(pixel);

        color.setBackgroundColor(Color.rgb(r, g, b));
        textView.setText("R: " + r + " " + "G: " + g + " " + "B: " + b);
        hexVal = String.format("#%02X%02X%02X", r, g, b);
        hex.setText("HEX: "+hexVal);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = imageView.getDrawingCache();
                    if((int)motionEvent.getX() < bitmap.getWidth() && (int)motionEvent.getY() < bitmap.getHeight() && (int)motionEvent.getY() >= 0) {
                        int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                        int r = Color.red(pixel);
                        int g = Color.green(pixel);
                        int b = Color.blue(pixel);

                        canvas.xVal = (int) motionEvent.getX();
                        canvas.yVal = (int) motionEvent.getY();
                        canvas.invalidate();
                        color.setBackgroundColor(Color.rgb(r, g, b));
                        textView.setText("R: " + r + " " + "G: " + g + " " + "B: " + b);
                        hexVal = String.format("#%02X%02X%02X", r, g, b);
                        hex.setText("HEX: "+hexVal);
                    }
                }
                return true;
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("color", hexVal);
                startActivityForResult(intent, 200);
            }
        });
    }
}