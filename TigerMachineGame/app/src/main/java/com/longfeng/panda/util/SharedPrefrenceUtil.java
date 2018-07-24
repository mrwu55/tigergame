package com.longfeng.panda.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by WuJingCheng on 2017/12/12.
 */

public class SharedPrefrenceUtil {
    private SharedPreferences preference;
    private static SharedPrefrenceUtil sharedPrefrenceUtil;
    public SharedPrefrenceUtil(Context context) {
        preference = context.getSharedPreferences("tigermachinegame", Context.MODE_PRIVATE);
    }

    public static SharedPrefrenceUtil getInstance(Context context) {
        if(sharedPrefrenceUtil==null){
            sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
        }
        return sharedPrefrenceUtil;
    }

    public void setUserName(String userName){
        preference.edit().putString("userName",userName).commit();
    }
    public String getUserName(){
        return preference.getString("userName",null);
    }
    public void setUserPassW(String userName){
        preference.edit().putString("userPss",userName).commit();
    }
    public String getUserPassW(){
        return preference.getString("userPss",null);
    }

    public void setIsCheck(boolean isCheck){
        preference.edit().putBoolean("isCheck",isCheck).commit();
    }
    public boolean getIsCheck(){
        return preference.getBoolean("isCheck",false);
    }
}

