package com.blyy.game.tigermachinegame.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by WuJingCheng on 2018/5/24.
 */

public class ToastUtil {
    public static void toast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
