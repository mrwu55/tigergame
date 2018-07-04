package com.blyy.game.tigermachinegame.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by WuJingCheng on 2018/5/24.
 */

public class ToastUtil {
    public static Toast mToast;
    public static void toast(Context context,String msg){
        if(mToast==null){
            mToast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
