package com.blyy.game.tigermachinegame.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.activity.App;
import com.blyy.game.tigermachinegame.bean.LoginBean;
import com.blyy.game.tigermachinegame.bean.RegistBean;
import com.blyy.game.tigermachinegame.util.CheckHelper;
import com.blyy.game.tigermachinegame.util.OkHttpUtils;
import com.blyy.game.tigermachinegame.util.SharedPrefrenceUtil;
import com.blyy.game.tigermachinegame.util.ToastUtil;
import com.blyy.game.tigermachinegame.view.RegistDialog;
import com.blyy.game.tigermachinegame.view.Test;

import okhttp3.FormBody;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private RegistDialog registDialog;
    private EditText mEditCode,mEditName,mEditPss,mEditSurePss;
    private EditText mEditLoginName,mEditLoginPss;
    private EditText mEditUrl ;
    private SharedPrefrenceUtil sharedPrefrenceUtil;
    private  String name,pss;
    private Button mBtnLogin,mBtnRegist;
    private ImageView mImgExit;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    LoginBean loginBean = (LoginBean) msg.obj;
                    if(loginBean ==null)return;
                    int status = loginBean.getStatus();
                    if(status==1) {
                        sharedPrefrenceUtil.setUserName(name);
                        sharedPrefrenceUtil.setUserPassW(pss);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("loginBean",loginBean);
                        showFragment(bundle,1);
                    }else {
                        String error = loginBean.getMsg();
                        ToastUtil.toast(getContext(),error==null?"数据错误":error);
                    }
                    break;
                case 1:
                    RegistBean registBean = (RegistBean) msg.obj;
                    if(registBean ==null)return;
                    int statuCode = registBean.getStatus();
                    registDialog.dismiss();
                    if(statuCode==1) {
                        ToastUtil.toast(getContext(),registBean.getMsg());
                    }else {
                        String error = registBean.getMsg();
                        ToastUtil.toast(getContext(),error==null?"数据错误":error);
                    }
                    break;
            }
        }
    };


    @Override
    protected int setView() {
        return R.layout.activity_main;
    }
    @Override
    protected void init(View view) {
        sharedPrefrenceUtil = SharedPrefrenceUtil.getInstance(getActivity());
        mEditLoginName = (EditText) view.findViewById(R.id.edit_login_name);
        mEditLoginPss = (EditText) view.findViewById(R.id.edit_login_pss);
        mImgExit = view.findViewById(R.id.img_main_exit);
        mEditUrl = (EditText) view.findViewById(R.id.edit_url);
        mBtnLogin = view.findViewById(R.id.login_btn);
        mBtnRegist = view.findViewById(R.id.regist_btn);
        mBtnLogin.setOnClickListener(this);
        mBtnRegist.setOnClickListener(this);
        mImgExit.setOnClickListener(this);
        int color=  getResources().getColor(R.color.dark);
        mEditLoginName.setHintTextColor(color);
        mEditLoginPss.setHintTextColor(color);
        String name = sharedPrefrenceUtil.getUserName();
        String pss = sharedPrefrenceUtil.getUserPassW();
        if(name!=null){
            mEditLoginName.setText(name);
        }
        if(pss!=null){
            mEditLoginPss.setText(pss);
        }
    }
    private void setDialog(){
        if(registDialog==null){
            registDialog = new RegistDialog(getActivity());
        }
        registDialog.show();
        Window window = registDialog.getWindow() ;
        window.setContentView(R.layout.regist_dialog_bg);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.relayout);
        ImageView mImgClose = (ImageView) window.findViewById(R.id.img_regist_close);
        mEditCode = (EditText) window.findViewById(R.id.edit_regist_code);
        mEditName = (EditText) window.findViewById(R.id.edit_regist_name);
        mEditPss = (EditText) window.findViewById(R.id.edit_regist_pss);
        mEditSurePss = (EditText) window.findViewById(R.id.edit_regist_surepss);
        Button buttonSure = (Button) window.findViewById(R.id.btn_regist_sure);
        Button buttonCancel = (Button) window.findViewById(R.id.btn_regist_cancel);
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

    @Override
    public void onClick(View v) {
        App.getApp().playBtn();
        switch (v.getId()){
            case R.id.login_btn:
                name = mEditLoginName.getText().toString();
                if(name.isEmpty()){
                    ToastUtil.toast(getActivity(),"用户名不能为空！");
                    return;
                }
                if(!CheckHelper.isValidName(name)){
                    ToastUtil.toast(getActivity(),"用户名不合法！");
                    return;
                }
                String uniCodeName =  gbEncoding(name);
                pss = mEditLoginPss.getText().toString();
                if(pss.isEmpty()){
                    ToastUtil.toast(getActivity(),"密码不能为空！");
                    return;
                }
                if(!CheckHelper.isValidPss(pss)){
                    ToastUtil.toast(getActivity(),"用户密码不合法！");
                    return;
                }
                String url = mEditUrl.getText().toString();
                if(!url.isEmpty()){
                    Test.URL = "http://"+url+"/XprojectApp/";
                }
                Log.e(" Constans.URL", Constans.LOGIN);
                OkHttpUtils.getData(getActivity(), Constans.LOGIN,
                        new FormBody.Builder().add("uName",uniCodeName).
                                add("uPass",pss).build(), LoginBean.class,handler,0);
                break;
            case R.id.regist_btn:
                setDialog();
                break;
            case R.id.img_main_exit:
                getActivity().finish();
                break;
            case R.id.btn_regist_sure:
                try {
                    App.getApp().playBtn();
                    String code = mEditCode.getText().toString();
                    if(code.isEmpty()){
                        ToastUtil.toast(getActivity(),"邀请码不能为空！");
                        return;
                    }
                    String name = mEditName.getText().toString();
                    if(name.isEmpty()){
                        ToastUtil.toast(getActivity(),"账户不能为空！");
                        return;
                    }
                    if(!CheckHelper.isValidName(name)){
                        ToastUtil.toast(getActivity(),"用户名不合法！");
                        return;
                    }
                    String strUTF8 = gbEncoding(name);
                    String pss = mEditPss.getText().toString();
                    if(pss.isEmpty()){
                        ToastUtil.toast(getActivity(),"密码不能为空！");
                        return;
                    }
                    if(!CheckHelper.isValidPss(pss)){
                        ToastUtil.toast(getActivity(),"用户密码不合法！");
                        return;
                    }
                    String pssSure = mEditSurePss.getText().toString();
                    if(pssSure.isEmpty()){
                        ToastUtil.toast(getActivity(),"请再次输入密码！");
                        return;
                    }
                    if(!pssSure.equals(pss)){
                        ToastUtil.toast(getActivity(),"两次密码输入不一致！");
                        return;
                    }
                    OkHttpUtils.getData(getActivity(), Constans.REGIST,new FormBody.Builder().
                            add("bicode",code).add("uName",strUTF8).
                            add("uPass",pss).build(), RegistBean.class,handler,1);

                }catch (Exception r){
                    r.printStackTrace();
                }
                break;
            case R.id.img_regist_close:
                registDialog.dismiss();
                break;
            case R.id.btn_regist_cancel:
                App.getApp().playBtn();
                registDialog.dismiss();
                break;
        }
    }
    public  String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }
    public interface OnLoginSuccess{
        void onLoginSuccess(LoginBean loginBean);
        void onExitApp();
    }
}
