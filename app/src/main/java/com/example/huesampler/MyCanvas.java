package com.example.huesampler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCanvas extends View {

    int xVal;
    int yVal;
    public MyCanvas(Context context) {
        super(context);
        init();
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    protected Paint circle;
    public void init(){
        circle = new Paint();
        circle.setColor(Color.RED);
        circle.setStrokeWidth(8);
        circle.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.xVal = w/2;
        this.yVal = h/2;
        super.onSizeChanged(w, h, oldw, oldh);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(xVal,yVal,80,circle);
    }
}
