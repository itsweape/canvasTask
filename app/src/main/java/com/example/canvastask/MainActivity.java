package com.example.canvastask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //properti untuk menggambar
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    //warna
    private int mColorBackground;
    private int mColorBody;
    private int mColorTempurung;
    private int mColorTempurung2;
    private int mColorEyes;
    private int mColorText;

    //counter ketika klik
    private int onClick = 0;

    //agar text ditengah
    private Rect mBounds = new Rect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.background, null);
        mColorBody = ResourcesCompat.getColor(getResources(), R.color.body, null);
        mColorTempurung = ResourcesCompat.getColor(getResources(), R.color.tempurung, null);
        mColorTempurung2 = ResourcesCompat.getColor(getResources(), R.color.tempurung2, null);
        mColorEyes = ResourcesCompat.getColor(getResources(), R.color.black, null);
        mColorText = ResourcesCompat.getColor(getResources(), R.color.tempurung, null);

        mPaint.setColor(mColorBackground);
        mPaintText.setColor(mColorText);
        mPaintText.setTextSize(70);

        mImageView = findViewById(R.id.image_view);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view);
            }
        });

    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();

        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;

        if (onClick == 0) {
            mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap);
            mCanvas.drawColor(mColorBackground);
        }else if (onClick == 1) {
            mPaint.setColor(mColorBody);
            mCanvas.drawCircle(halfWidth, halfHeight-270, halfHeight/6, mPaint);
        }else if (onClick == 2){
            mPaint.setColor(mColorBody);
            mCanvas.drawCircle(halfWidth+200, halfHeight-100, halfHeight/9, mPaint);
            mCanvas.drawCircle(halfWidth-200, halfHeight-100, halfHeight/9, mPaint);
        }else if (onClick == 3) {
            mPaint.setColor(mColorBody);
            mCanvas.drawCircle(halfWidth+200, halfHeight+110, halfHeight/9, mPaint);
            mCanvas.drawCircle(halfWidth-200, halfHeight+110, halfHeight/9, mPaint);
        }else if (onClick == 4){
            mPaint.setColor(mColorBody);
            mCanvas.drawCircle(halfWidth, halfHeight+200, halfHeight/13, mPaint);
        }else if (onClick == 5) {
            mPaint.setColor(mColorTempurung);
            mCanvas.drawCircle(halfWidth, halfHeight, halfHeight/3, mPaint);
        }else if (onClick == 6) {
            mPaint.setColor(mColorTempurung2);
            mCanvas.drawCircle(halfWidth, halfHeight, halfHeight/5, mPaint);
        }else if (onClick == 7) {
            mPaint.setColor(mColorTempurung);
            mCanvas.drawCircle(halfWidth, halfHeight, halfHeight/10, mPaint);
        }else if (onClick == 8) {
            mPaint.setColor(mColorEyes);
            mCanvas.drawCircle(halfWidth+45, halfHeight-280, halfHeight/22, mPaint);
            mCanvas.drawCircle(halfWidth-45, halfHeight-280, halfHeight/22, mPaint);
        } else{
            String text = getString(R.string.text1);
            mPaintText.getTextBounds(text, 0, text.length(), mBounds);
            int x = halfWidth - mBounds.centerX();
            int y = halfHeight + 400;
            mCanvas.drawText(text, x, y, mPaintText);
        }
        onClick += 1;
        view.invalidate();
    }
}
