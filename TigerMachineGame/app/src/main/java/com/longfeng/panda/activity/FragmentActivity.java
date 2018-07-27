package com.longfeng.panda.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.util.Log;
import com.longfeng.panda.Constans;
import com.longfeng.panda.R;
import com.longfeng.panda.bean.LuckyBean;
import com.longfeng.panda.fragment.BackHandlerHelper;
import com.longfeng.panda.fragment.BaseFragment;
import com.longfeng.panda.fragment.ChooseSeatFragment;
import com.longfeng.panda.fragment.HouseFragment;
import com.longfeng.panda.fragment.LoginFragment;
import com.longfeng.panda.fragment.PlayFragment;
import com.longfeng.panda.fragment.RecordFragment;
import com.longfeng.panda.util.ChangeOrientationHandler;
import com.longfeng.panda.util.OrientationSensorListener;
import com.longfeng.panda.util.PlayGameNetWorkUtil;
import com.longfeng.panda.view.AndroidBug5497Workaround;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;

public class FragmentActivity extends android.support.v4.app.FragmentActivity
        implements BaseFragment.OnBackClickListner
{
    private OrientationSensorListener listener;
    private SensorManager sm;
    private Sensor sensor;
    private ChangeOrientationHandler oritationHandler;
    private FragmentTransaction transaction;
    private LoginFragment loginFragment;
    private HouseFragment houseFragment;
    private ChooseSeatFragment chooseSeatFragment;
    private PlayFragment playFragment;
    private RecordFragment recordFragment;
    private FragmentManager mFragmentManager;
    private HorizontalScrollView mReTips;
    private TextView mTvTips;
    private int width;
    private  Runnable task,sysTask;
    private ArrayList<String> luckyList = new ArrayList<>();
    private long sysTipsTime=0;
    private boolean isFirst = true;
    @SuppressLint("HandlerLeak")
    private Handler mHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    PlayGameNetWorkUtil.getDataLucky(FragmentActivity.this,
                            Constans.GET_LUCKY, new FormBody.Builder().build(),
                            LuckyBean.class, mHanlder, 3);
                    break;
//                case 2:
//                    startSystemTips();
//                    break;
                case 3://通知信息
                LuckyBean luckyBean = (LuckyBean) msg.obj;
                luckyList.clear();
                if(luckyBean==null) return;
                int status = luckyBean.getStatus();
                if(status==1){
                    List<LuckyBean.DataBean.MessageVosBean> messageVosBeans = luckyBean.getData().getMessageVos();
                    if(messageVosBeans==null||messageVosBeans.size()==0) return;
                    for (LuckyBean.DataBean.MessageVosBean messageVosBean:messageVosBeans){
                        int type=messageVosBean.getMsgType();
                        String message = messageVosBean.getMessage();
                        if(type==1){//系统通知
                            if(isFirst){
                                luckyList.add(message);
                            }
                            sysTipsTime = messageVosBean.getShowTime()*60000;
                        }else {
                            luckyList.add(message);
                        }
                    }
                    if(isFirst){
                        isFirst = false;
                        if(sysTask==null&&task==null){
                            sysTask = new Runnable() {
                                @Override
                                public void run() {
                                    isFirst = true;
                                    mHanlder.sendEmptyMessage(1);
                                    mHanlder.postDelayed(this, sysTipsTime);
                                }
                            };
                            mHanlder.postDelayed(sysTask, sysTipsTime);
                            task = new Runnable() {
                                @Override
                                public void run() {
                                    /**
                                     * 此处执行任务
                                     * */
                                    mHanlder.sendEmptyMessage(1);
                                    mHanlder.postDelayed(this, 180000);
                                }
                            };
                            mHanlder.postDelayed(task, 180000);
                        }
                        startLuckyAnim();
                        return;
                    }
                    startLuckyAnim();
                }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oritationHandler = new ChangeOrientationHandler(this);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new OrientationSensorListener(oritationHandler);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        },2000);
    }
    private void init() {
        setContentView(R.layout.activity_fragment);
        AndroidBug5497Workaround.assistActivity(this);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        mReTips = findViewById(R.id.re_fragmentac_tip);
        mTvTips = findViewById(R.id.tv_basef_tip);
        mFragmentManager = getSupportFragmentManager();
        transaction = mFragmentManager.beginTransaction();
        if(loginFragment==null){
            loginFragment = new LoginFragment();
        }
        transaction.add(R.id.fragment_base_frame, loginFragment).commitAllowingStateLoss();
    }

    private void startLuckyAnim(){
        if(luckyList.size()>0) {
            for (int i = 0; i < luckyList.size(); i++) {
                final int finalI = i;
                mHanlder.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startAnim(luckyList.get(finalI));
                    }
                }, i * 32000);
            }
        }
    }
    private void startAnim(String tips){
        mReTips.setVisibility(View.VISIBLE);
        mTvTips.clearAnimation();
        mTvTips.setText(tips);
        Animation animation = new TranslateAnimation(width, -width, 0, 0);
        animation.setDuration(10000);
        animation.setRepeatCount(2);//动画的重复次数
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(false);//设置为true，动画转化结束后被应用
        mTvTips.startAnimation(animation);//开始动画
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                mReTips.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (!BackHandlerHelper.handleBackPress(this)) {
            super.onBackPressed();
        }
    }
    @Override
    public void onBackClick(int position) {
        backFragment(position);
    }

    /**
     * fragment跳转监听
     * @param bundle
     * @param postion
     */
    @Override
    public void onFragmentShow(Bundle bundle, int postion) {
        transaction = mFragmentManager.beginTransaction();
        switch (postion){
            case 1:
                    transaction.hide(loginFragment);
                    houseFragment = HouseFragment.newInstance(bundle);
                    transaction.add(R.id.fragment_base_frame, houseFragment);
                     PlayGameNetWorkUtil.getDataLucky(this, Constans.GET_LUCKY, new FormBody.Builder().build(),
                         LuckyBean.class, mHanlder, 3);
                break;
            case 2:
                    transaction.hide(houseFragment);
                    chooseSeatFragment = ChooseSeatFragment.newInstance(bundle);
                    transaction.add(R.id.fragment_base_frame, chooseSeatFragment);
                break;
            case 3:
                transaction.hide(chooseSeatFragment);
                playFragment = PlayFragment.newInstance(bundle);
                transaction.add(R.id.fragment_base_frame, playFragment);
                break;
            case 4:
                transaction.hide(playFragment);
                recordFragment = RecordFragment.newInstance(bundle);
                transaction.add(R.id.fragment_base_frame, recordFragment);
                break;
        }
        transaction.commitAllowingStateLoss();
    }
    /**
     * 返回键监听
     * @param position
     */
    private void backFragment(int position){
        transaction = mFragmentManager.beginTransaction();
    switch (position){
        case 0:
            isFirst = true;
            Constans.Session = null;
            Constans.gold = null;
            if(task!=null){
                mHanlder.removeCallbacks(task);
                task = null;
            }
            if(sysTask!=null){
                mHanlder.removeCallbacks(sysTask);
                sysTask = null;
            }
            if(recordFragment!=null){
                transaction.remove(recordFragment).
                        remove(playFragment).
                        remove(chooseSeatFragment);
                recordFragment = null;
                playFragment = null;
                chooseSeatFragment = null;
            }
            if(playFragment!=null){
                transaction.remove(playFragment).remove(chooseSeatFragment);
                playFragment = null;
                chooseSeatFragment = null;
            }
            if(chooseSeatFragment!=null){
                transaction.remove(chooseSeatFragment);
                chooseSeatFragment = null;
            }
                transaction.remove(houseFragment);
                houseFragment = null;
                transaction.show(loginFragment).commitAllowingStateLoss();
            break;
        case 2:
            transaction.remove(chooseSeatFragment).show(houseFragment).commitAllowingStateLoss();
            chooseSeatFragment = null;
            break;
        case 3:
            transaction.remove(playFragment).show(chooseSeatFragment).commitAllowingStateLoss();
            playFragment = null;
            break;
        case 4:
            transaction.remove(recordFragment).show(playFragment).commitAllowingStateLoss();
            recordFragment = null;
            break;
          }
    }
    @Override
    protected void onResume() {
        sm.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
    @Override
    protected void onPause() {
        sm.unregisterListener(listener);
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        mHanlder.removeCallbacks(task);
        Log.e("OndesDroy","走了");
        super.onDestroy();
    }
}
