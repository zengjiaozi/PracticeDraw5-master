package com.hencoder.hencoderpracticedraw5.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class Sample03OnDrawLayout extends LinearLayout {
//    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Patter pattern = new Patter();


    public Sample03OnDrawLayout(Context context) {
        super(context);
    }

    public Sample03OnDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03OnDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        pattern.draw(canvas);

    }

    {
        // ViewGroup 需要主动开启 dispatchDraw() 以外的绘制
        setWillNotDraw(false);
    }

    private class Patter {
        private static final float PATTERN_RATIO = 5f / 6;
        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Sample03OnDrawLayout.Patter.Spot[] spots;

        {
            patternPaint.setColor(Color.BLACK);
        }

        //   空参数构造器
        private Patter() {
//            内部类的调用方式
            spots = new Sample03OnDrawLayout.Patter.Spot[4];
            spots[0] = new Sample03OnDrawLayout.Patter.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Sample03OnDrawLayout.Patter.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Sample03OnDrawLayout.Patter.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Sample03OnDrawLayout.Patter.Spot(0.62f, 0.78f, 0.083f);


        }

        public void draw(Canvas canvas) {

            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Sample03OnDrawLayout.Patter.Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }


        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
