package com.longfeng.panda.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by WuJingCheng on 2018/3/8.
 */

@SuppressLint("AppCompatCustomView")
public class NoPadingTextView extends TextView{
    public NoPadingTextView(Context context) {
        super(context);
    }

    public NoPadingTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoPadingTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    Paint.FontMetricsInt fontMetricsInt;
    @Override
    protected void onDraw(Canvas canvas) {
            if (fontMetricsInt == null){
                fontMetricsInt = new Paint.FontMetricsInt();
                getPaint().getFontMetricsInt(fontMetricsInt);
            canvas.translate(0, fontMetricsInt.top - fontMetricsInt.ascent);
        }
        super.onDraw(canvas);

    }
}
