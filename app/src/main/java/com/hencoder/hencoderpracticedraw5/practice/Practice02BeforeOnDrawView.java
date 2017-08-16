package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;

public class Practice02BeforeOnDrawView extends AppCompatTextView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); //抗锯齿
    RectF rectF = new RectF(); //矩形

    {
        paint.setTextSize(28);
        paint.setColor(Color.YELLOW);
    }

    public Practice02BeforeOnDrawView(Context context) {
        super(context, null);
    }

    public Practice02BeforeOnDrawView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public Practice02BeforeOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        int lineCount = layout.getLineCount();
        Log.i("zeng", "count =" + lineCount);
        rectF.left = layout.getLineLeft(0);
        rectF.right = layout.getLineRight(3);
        rectF.top = layout.getLineTop(0);
        rectF.bottom = layout.getLineBottom(3);

//       先绘制一个矩形
        canvas.drawRect(rectF, paint);


        super.onDraw(canvas);
    }
}
