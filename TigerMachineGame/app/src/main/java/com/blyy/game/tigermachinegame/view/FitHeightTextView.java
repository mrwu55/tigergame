package com.blyy.game.tigermachinegame.view;

/**
 * Created by WuJingCheng on 2018/3/19.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by akitaka on 2017/9/20.
 *
 * @filename FitHeightTextView
 * @describe 根据高度自适应字体文字大小
 */

@SuppressLint("AppCompatCustomView")
public class FitHeightTextView extends TextView {

    public FitHeightTextView(Context context) {
        super(context);
    }

    public FitHeightTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FitHeightTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
