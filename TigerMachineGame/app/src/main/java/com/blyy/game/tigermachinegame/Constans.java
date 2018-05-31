package com.blyy.game.tigermachinegame;

import android.util.Log;

import com.blyy.game.tigermachinegame.view.Test;

/**
 * Created by Administrator on 2018/2/11.
 */

public class Constans {

    public static int width = 0;
    //测试地址
//    public static  String Test.URL = "http://211.149.249.102:8070/XprojectApp/";
    //本机
//    public static String URL = "http://192.168.1.5:8080/XprojectApp/";
    //登录
    public static  String LOGIN = Test.URL+"userLogin/login";
    //JSESSIONID
    public static String Session = null;
    //注册
    public static  String REGIST = Test.URL+"userLogin/register";
    //修改密码
    public static  String CHANGEPSS = Test.URL+"userLogin/updatePass";
    //获取座位信息
    public static  String GETSEAT = Test.URL+"machine/queryMachineList";
    //游戏信息 getMachineInfo
    public static  String STARTGAME = Test.URL+"getMachineInfo";
    // 开始游戏 第一次
    public static  String PLAYONE = Test.URL+"gameStart";
    // 开始游戏 第二次 checkPokerInfe  checkPoker
    public static  String PLAYTWO = Test.URL+"checkPokerInfe";
    //上下分 integralUpdatetype（1为上分，0为下分）
    public static  String UPODOWN = Test.URL+"integralUpdate";
    //押分接口
    public static  String PUSHBET = Test.URL+"pushBet";
    //比倍
    public static  String THAN_TIMES = Test.URL+"thanTimes";
    //比倍选择 （0：押小，1：押大）
    public static  String SURETHANTIMES = Test.URL+"sureThanTimes";
    //得分 getIntegral
    public static  String GETSCORE = Test.URL+"getIntegral";
    //退出
    public static  String EXIT = Test.URL+"exitTheGame";
    //留机或游戏 进入
    public static  String JOINLIVE = Test.URL+"joinLiveGame";
    //留机
    public static  String KEEPGAME = Test.URL+"keepTheGame";
    //退出程序
    public static  String EXITALL= Test.URL+"exitGame";
    //记录
    public static  String RECORD= Test.URL+"record/getMachineRecord";
    //获取中奖信息
    public static  String GET_LUCKY= Test.URL+"message/getMessage";
    public static String gold = null;
    public static void showLogCompletion(String log,int showCount) {
        if (log.length() > showCount) {
            String show = log.substring(0, showCount);
//          System.out.println(show);
            Log.e("TAG", show + "");
            if ((log.length() - showCount) > showCount) {//剩下的文本还是大于规定长度
                String partLog = log.substring(showCount, log.length());
                showLogCompletion(partLog, showCount);
            } else {
                String surplusLog = log.substring(showCount, log.length());
//              System.out.println(surplusLog);
                Log.e("TAG", surplusLog + "");
            }

        } else {
//          System.out.println(log);
            Log.e("TAG", log + "");
        }
    }
}
