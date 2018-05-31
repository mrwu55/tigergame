package com.blyy.game.tigermachinegame.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.util.ChangeOrientationHandler;
import com.blyy.game.tigermachinegame.util.OrientationSensorListener;

public class BaseActivity extends Activity {
    private OrientationSensorListener listener;
    private SensorManager sm;
    private Sensor sensor;
    private ChangeOrientationHandler oritationHandler;
    private TextView mTvTips;
    private RelativeLayout mReTip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oritationHandler = new ChangeOrientationHandler(this);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new OrientationSensorListener(oritationHandler);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);
        ViewGroup vgContent = (ViewGroup) findViewById(R.id.layout_frame);
        LayoutInflater.from(this).inflate(layoutResID, vgContent);
        mTvTips = findViewById(R.id.tv_base_tip);
        mReTip = findViewById(R.id.re_base_tip);
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
}

