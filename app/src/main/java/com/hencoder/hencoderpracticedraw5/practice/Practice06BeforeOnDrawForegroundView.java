package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class Practice06BeforeOnDrawForegroundView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice06BeforeOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 30, paint);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0, 10, 200, 100, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("Hello", 10, 70, paint);


        super.onDrawForeground(canvas);
    }
}
