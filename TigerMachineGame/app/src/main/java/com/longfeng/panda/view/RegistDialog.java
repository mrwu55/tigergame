package com.longfeng.panda.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.longfeng.panda.R;

/**
 * Created by WuJingCheng
 * on 2018/2/9.
 */
public class RegistDialog extends Dialog{
    public RegistDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }
}
