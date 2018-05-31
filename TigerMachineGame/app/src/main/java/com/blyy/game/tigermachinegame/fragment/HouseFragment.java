package com.blyy.game.tigermachinegame.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.activity.App;
import com.blyy.game.tigermachinegame.adapter.HomeGridAdapter;
import com.blyy.game.tigermachinegame.bean.ExitBean;
import com.blyy.game.tigermachinegame.bean.LoginBean;
import com.blyy.game.tigermachinegame.bean.RegistBean;
import com.blyy.game.tigermachinegame.util.CheckHelper;
import com.blyy.game.tigermachinegame.util.OkHttpUtils;
import com.blyy.game.tigermachinegame.util.SharedPrefrenceUtil;
import com.blyy.game.tigermachinegame.util.ToastUtil;
import com.blyy.game.tigermachinegame.view.RegistDialog;

import okhttp3.FormBody;

public class HouseFragment extends BaseFragment implements View.OnClickListener{
    private RegistDialog registDialog,tipsDialog,exitDialog,helpDialog;
    private EditText mEditoldPss,mEditnewPss,mEditSurePss;
    private CheckBox mCheckBox;
    private boolean ischeck;
    private GridView mGridView;
    private LoginBean loginBean;
    private TextView mTvName,mTvGold;
    private String name,gold;
    private int gridViewWidth=0;
    private SharedPrefrenceUtil sharedPrefrenceUtil;
    private Button mBtnChangePss;
    private ImageView mImgExit;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    RegistBean registBean = (RegistBean) msg.obj;
                    if(registBean==null) return;
                    registDialog.dismiss();
                    int status  = registBean.getStatus();
                    ToastUtil.toast(getContext(),registBean.getMsg());
                    if(status==1||status==3){
                        setBackPosition(0);
                    }
                    break;
                case 1://退出
                    ExitBean exitBean = (ExitBean) msg.obj;
                    int errorstatu = exitBean.getStatus();
                    if(errorstatu!=1){
                        ToastUtil.toast(getContext(),exitBean.getMsg());
                    }
                    setBackPosition(0);
                    break;
            }
        }
    };

    public static HouseFragment newInstance(Bundle bundle) {
        HouseFragment fragment = new HouseFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected int setView() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void init(View view) {
        sharedPrefrenceUtil = SharedPrefrenceUtil.getInstance(getContext());
        ischeck = sharedPrefrenceUtil.getIsCheck();
        mTvName = (TextView) view.findViewById(R.id.tv_home_name);
        mTvGold = (TextView) view.findViewById(R.id.tv_home_money);
        mBtnChangePss = view.findViewById(R.id.btn_home_changepss);
        mImgExit = view.findViewById(R.id.img_home_exit);
        mBtnChangePss.setOnClickListener(this);
        mImgExit.setOnClickListener(this);
        Bundle bundle = getArguments();
        if (bundle!= null) {
             loginBean = (LoginBean) bundle.getSerializable("loginBean");
            name = loginBean.getData().getUsers().getUName();
            gold = loginBean.getData().getUsers().getUGold()+"";
            mTvName.setText(name);
            mTvGold.setText("当前余额："+gold);

        }
        mCheckBox = (CheckBox) view.findViewById(R.id.checkbox_home);
        mCheckBox.setChecked(ischeck);
        mGridView = (GridView) view.findViewById(R.id.home_grid);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                App.getApp().playBtn();
                ischeck = isChecked;
                sharedPrefrenceUtil.setIsCheck(isChecked);
            }
        });
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                App.getApp().playBtn();
                if(!ischeck){
                    setTipsDialog();
                    return;
                }
                String roomName = loginBean.getData().getRateTypeList().get(i).getRtName();
                String rtId = loginBean.getData().getRateTypeList().get(i).getRtId()+"";
                Bundle bundle = new Bundle();
                bundle.putString("roomName",roomName);
                bundle.putString("money",gold);
                bundle.putString("useName",name);
                bundle.putString("rtId",rtId);
                showFragment(bundle,2);
            }
        });
        ViewTreeObserver observer = mGridView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (gridViewWidth==0) {
                    gridViewWidth = mGridView.getMeasuredWidth();
                    mGridView.setAdapter(new HomeGridAdapter(loginBean.getData().getRateTypeList(), gridViewWidth));
                }
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            if(Constans.gold!=null){
                mTvGold.setText("当前余额："+Constans.gold);
            }
        }
    }

    private void setDialog(){
        if(registDialog==null){
            registDialog = new RegistDialog(getContext());
        }
        registDialog.show();
        Window window = registDialog.getWindow() ;
        window.setContentView(R.layout.lay_changepss);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.relayout_change);
        ImageView mImgClose = (ImageView) window.findViewById(R.id.img_change_close);
        mEditoldPss = (EditText) window.findViewById(R.id.edit_change_oldpss);
        mEditnewPss = (EditText) window.findViewById(R.id.edit_change_newpss);
        mEditSurePss = (EditText) window.findViewById(R.id.edit_change_surepss);
        Button buttonSure = (Button) window.findViewById(R.id.btn_change_sure);
        Button buttonCancel = (Button) window.findViewById(R.id.btn_change_cancel);
        mImgClose.setOnClickListener(this);
        buttonSure.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        Display display =getActivity().getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();              //使用这种方式更改了dialog的框高
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();                     //使用这种方式更改了dialog的框宽
        window.setAttributes(params);
    }
    private void setTipsDialog(){
        if(tipsDialog==null){
            tipsDialog = new RegistDialog(getContext());
        }
        tipsDialog.show();
        Window window = tipsDialog.getWindow() ;
        window.setContentView(R.layout.home_tips);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_home_tips);
        ImageView mImgClose = (ImageView) window.findViewById(R.id.img_tips_close);
        mImgClose.setOnClickListener(this);
        Display display =getActivity().getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();              //使用这种方式更改了dialog的框高
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();                     //使用这种方式更改了dialog的框宽
        window.setAttributes(params);
    }
    private void setExitDialog(){
        if(exitDialog==null){
            exitDialog = new RegistDialog(getContext());
        }
        exitDialog.show();
        Window window = exitDialog.getWindow() ;
        window.setContentView(R.layout.exit_tips);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_dialog_exit);
        Button buttonSure = (Button) window.findViewById(R.id.btn_exit_sure);
        Button buttonCancel = (Button) window.findViewById(R.id.btn_exit_cancel);
        buttonSure.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        Display display =getActivity().getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();              //使用这种方式更改了dialog的框高
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();                     //使用这种方式更改了dialog的框宽
        window.setAttributes(params);
    }
    @Override
    public boolean onBackPressed() {
        App.getApp().playBtn();
        setExitDialog();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home_changepss:
                App.getApp().playBtn();
                setDialog();
                break;
            case R.id.img_home_exit:
                App.getApp().playBtn();
                setExitDialog();
                break;
            case R.id.btn_change_sure:
                App.getApp().playBtn();
                String oldPss = mEditoldPss.getText().toString();
                if(oldPss.isEmpty()){
                    ToastUtil.toast(getContext(),"请输入旧密码！");
                    return;
                }
                String newPss = mEditnewPss.getText().toString();
                if(newPss.isEmpty()){
                    ToastUtil.toast(getContext(),"请输入新密码！");
                    return;
                }
                if(!CheckHelper.isValidPss(newPss)){
                    ToastUtil.toast(getContext(),"用密码不合法！");
                    return;
                }
                String surePss = mEditSurePss.getText().toString();
                if(surePss.isEmpty()){
                    ToastUtil.toast(getContext(),"请输入再次输入新密码！");
                    return;
                }
                if(!surePss.equals(newPss)){
                    ToastUtil.toast(getContext(),"两次输入不一致！");
                    return;
                }
                OkHttpUtils.getData(getActivity(), Constans.CHANGEPSS,new FormBody.Builder().
                        add("uPass",oldPss).
                        add("newUpass",newPss).build(), RegistBean.class,handler,0);
                break;
            case R.id.btn_change_cancel:
                App.getApp().playBtn();
                registDialog.dismiss();
                break;
            case R.id.img_change_close:
                registDialog.dismiss();
                break;
            case R.id.img_tips_close:
                tipsDialog.dismiss();
                break;
            case R.id.btn_exit_sure:
                exitDialog.dismiss();
                OkHttpUtils.getData(getActivity(),
                        Constans.EXITALL,new FormBody.Builder().build(),
                        ExitBean.class,handler,1);
                break;
            case R.id.btn_exit_cancel:
                exitDialog.dismiss();
                break;
            case R.id.img_help_close:
                helpDialog.dismiss();
                break;
        }
    }
}
