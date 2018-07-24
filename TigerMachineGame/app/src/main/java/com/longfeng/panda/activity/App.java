package com.longfeng.panda.activity;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longfeng.panda.R;
import com.longfeng.panda.util.ChooseBrandUtils;
import com.longfeng.panda.view.RegistDialog;
import com.tencent.bugly.Bugly;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WuJingCheng
 * on 2018/2/9.
 */
public class App extends Application{
    private static App app;
    private RegistDialog registDialog,tipsDialog;
    private SoundPool soundPool;//声明一个SoundPool
    int  soundID,soundinit;
    private MediaPlayer mediaPlayer;
    public static Typeface typeFace;
    private Map<String,Integer> mapBrand = new HashMap<>();
    public SoundPool getSoundPool() {
        return soundPool;
    }
    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "6ca9162fb7", false);
        setTypeface();
        app =this;
        ChooseBrandUtils.putBrand(mapBrand);
        mediaPlayer =MediaPlayer.create(this,R.raw.lambada);
        mediaPlayer.setLooping(false);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID = soundPool.load(this,R.raw.click, 1);
        soundinit = soundPool.load(this,R.raw.init_bg, 1);
    }
    public void showDialog(Activity activity){
        registDialog = new RegistDialog(activity);
        registDialog.show();
        Window window = registDialog.getWindow() ;
        window.setContentView(R.layout.login_bg);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_loading);
        Display display =activity.getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();              //使用这种方式更改了dialog的框高
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();                     //使用这种方式更改了dialog的框宽
        window.setAttributes(params);
    }
    public void dissmissDialog(){
        if(registDialog!=null&&registDialog.isShowing()){
            registDialog.dismiss();
        }
    }
    public void showTipsDialog(Activity activity){
        if(tipsDialog!=null&&tipsDialog.isShowing()){
            return;
        }
        tipsDialog = new RegistDialog(activity);
        tipsDialog.show();
        Window window = tipsDialog.getWindow() ;
        window.setContentView(R.layout.home_tips);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_home_tips);
        TextView textView  = (TextView) window.findViewById(R.id.tv_tipdialog_tip);
        ImageView mImgClose = (ImageView) window.findViewById(R.id.img_tips_close);
        textView.setText("网络连接错误，请检查网络设置!");
        mImgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipsDialog.dismiss();
            }
        });
        Display display =activity.getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();
        window.setAttributes(params);
    }
    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }
    public void playBtn(){
        soundPool.play(
                soundID,
                1.0f,   //左耳道音量【0~1】
                1.0f,   //右耳道音量【0~1】
                9,     //播放优先级【0表示最低优先级】
                0,     //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1     //播放速度【1是正常，范围从0~2】
        );
         }
    public void playInit(){
        soundPool.play(
                soundinit,
                1.0f,   //左耳道音量【0~1】
                1.0f,   //右耳道音量【0~1】
                9,     //播放优先级【0表示最低优先级】
                0,     //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1     //播放速度【1是正常，范围从0~2】
        );
    }
    /**
     * 通过反射方法设置app全局字体
     */
    public void setTypeface() {
        typeFace = Typeface.createFromAsset(getAssets(), "bbb.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("SERIF");
            field.setAccessible(true);
            field.set(null, typeFace);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getBrandSoruce(String brand) {
        return mapBrand.get(brand);
    }
}
