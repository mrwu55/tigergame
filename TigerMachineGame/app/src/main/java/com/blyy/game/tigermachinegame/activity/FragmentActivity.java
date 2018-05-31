package com.blyy.game.tigermachinegame.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.bean.LuckyBean;
import com.blyy.game.tigermachinegame.fragment.BackHandlerHelper;
import com.blyy.game.tigermachinegame.fragment.BaseFragment;
import com.blyy.game.tigermachinegame.fragment.ChooseSeatFragment;
import com.blyy.game.tigermachinegame.fragment.HouseFragment;
import com.blyy.game.tigermachinegame.fragment.LoginFragment;
import com.blyy.game.tigermachinegame.fragment.PlayFragment;
import com.blyy.game.tigermachinegame.fragment.RecordFragment;
import com.blyy.game.tigermachinegame.util.ChangeOrientationHandler;
import com.blyy.game.tigermachinegame.util.OrientationSensorListener;
import com.blyy.game.tigermachinegame.util.PlayGameNetWorkUtil;

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
    private String tips ="哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈";
    private String lucky_tips ="";
    private long sysTipsTime=0;
    private boolean isFirst = true;
    @SuppressLint("HandlerLeak")
    private Handler mHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    PlayGameNetWorkUtil.getData(FragmentActivity.this, Constans.GET_LUCKY, new FormBody.Builder().build(),
                            LuckyBean.class, mHanlder, 3);
                    break;
                case 2:
                    startAnim(tips);
                    break;
                case 3://通知信息
                LuckyBean luckyBean = (LuckyBean) msg.obj;
                if(luckyBean==null) return;
                    lucky_tips = "";
//                    tips = "";
                int status = luckyBean.getStatus();
                if(status==1){
                    List<LuckyBean.DataBean.MessageVosBean> messageVosBeans = luckyBean.getData().getMessageVos();
                    if(messageVosBeans==null||messageVosBeans.size()==0) return;
                    for (LuckyBean.DataBean.MessageVosBean messageVosBean:messageVosBeans){
                        int type=messageVosBean.getMsgType();
                        String message = messageVosBean.getMessage();
                        if(type==1){//系统通知
                            tips +=message;
                            sysTipsTime = messageVosBean.getShowTime()*60000;
                        }else {
                            lucky_tips += message;
                        }
                    }
                    if(isFirst){
                        isFirst = false;
                        startAnim(tips);
                        sysTask = new Runnable() {
                            @Override
                            public void run() {
                                mHanlder.sendEmptyMessage(2);
                                mHanlder.postDelayed(this, sysTipsTime);
                            }
                        };
                        mHanlder.postDelayed(sysTask, sysTipsTime);
                        if(!("").equals(lucky_tips)) {
                            mHanlder.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startAnim(lucky_tips);
                                }
                            }, 35000);
                        }
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

                        return;
                    }
//                    if(sysTask!=null){
//                        mHanlder.removeCallbacks(sysTask);
//                        sysTask =null;
//                    }
                    if(!"".equals(lucky_tips)){
                        startAnim(lucky_tips);
                    }
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
        transaction.add(R.id.fragment_base_frame, loginFragment).commit();
    }
    private void startAnim(String tips){
        mReTips.setVisibility(View.VISIBLE);
        mTvTips.clearAnimation();
        mTvTips.setText(tips);
//        mTvTips.setSelected(true);
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
                     PlayGameNetWorkUtil.getData(this, Constans.GET_LUCKY, new FormBody.Builder().build(),
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
        transaction.commit();
    }

    /**
     * 返回键监听
     * @param position
     */
    private void backFragment(int position){
        transaction = mFragmentManager.beginTransaction();
    switch (position){
        case 0:
            Log.e("backFragment 0","走了");
            isFirst = true;
            tips = "";
            lucky_tips = "";
            Constans.Session = null;
            if(task!=null){
                mHanlder.removeCallbacks(task);
            }
            if(sysTask!=null){
                mHanlder.removeCallbacks(sysTask);
            }
            if(recordFragment!=null){
                transaction.remove(recordFragment).remove(playFragment).remove(chooseSeatFragment).remove(houseFragment);
                recordFragment = null;
                playFragment = null;
                chooseSeatFragment = null;
                houseFragment = null;
                transaction.show(loginFragment).commit();
                return;
            }
            if(playFragment!=null){
                transaction.remove(playFragment).remove(chooseSeatFragment).remove(houseFragment);
                playFragment = null;
                chooseSeatFragment = null;
                houseFragment = null;
                transaction.show(loginFragment).commit();
                return;
            }
            if(chooseSeatFragment!=null){
                transaction.remove(chooseSeatFragment).remove(houseFragment);
                chooseSeatFragment = null;
                houseFragment = null;
                transaction.show(loginFragment).commit();
                return;
            }
                transaction.remove(houseFragment);
                houseFragment = null;
                transaction.show(loginFragment).commit();
                mHanlder.removeCallbacks(task);
            break;
        case 2:
            transaction.remove(chooseSeatFragment).show(houseFragment).commit();
            chooseSeatFragment = null;
            break;
        case 3:
            transaction.remove(playFragment).show(chooseSeatFragment).commit();
            playFragment = null;
            break;
        case 4:
            transaction.remove(recordFragment).show(playFragment).commit();
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
        super.onDestroy();
    }
}
