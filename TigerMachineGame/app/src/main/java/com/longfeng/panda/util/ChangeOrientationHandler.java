package com.longfeng.panda.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;

/**
 * Created by WuJingCheng on 2018/4/2.
 */

public class ChangeOrientationHandler extends Handler {
    private Activity activity;
    public ChangeOrientationHandler(Activity ac) {
        super();
        activity = ac;
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.what == 888) {
            int orientation = msg.arg1;
            if (orientation > 45 && orientation < 135) {//左
                activity.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                Log.e("main", "横屏翻转: ");
            }  else if (orientation > 225 && orientation < 315) {
                activity.setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
        super.handleMessage(msg);
    }
}
