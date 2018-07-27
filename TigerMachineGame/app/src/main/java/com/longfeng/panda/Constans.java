package com.longfeng.panda;

import android.util.Log;

/**
 * Created by Administrator on 2018/2/11.
 */

public class Constans {

    public static String  URL = "http://39.108.155.228:8080/XprojectApp/";
//    测试地址
//    public static  String URL = "http://211.149.249.102:8070/XprojectApp/";
    //本机
//    public static String URL = "http://192.168.43.107:8080/XprojectApp/";
    //登录
    public static  String LOGIN = URL+"userLogin/login";
    //JSESSIONID
    public static String Session = null;
    //注册
    public static  String REGIST = URL+"userLogin/register";
    //修改密码
    public static  String CHANGEPSS = URL+"userLogin/updatePass";
    //获取座位信息
    public static  String GETSEAT = URL+"machine/queryMachineList";
    //游戏信息 getMachineInfo
    public static  String STARTGAME = URL+"getMachineInfo";
    // 开始游戏 第一次
    public static  String PLAYONE = URL+"gameStart";
    // 开始游戏 第二次 checkPokerInfe  checkPoker
    public static  String PLAYTWO = URL+"checkPokerInfe";
    //上下分 integralUpdatetype（1为上分，0为下分）
    public static  String UPODOWN = URL+"integralUpdate";
    //押分接口
    public static  String PUSHBET = URL+"pushBet";
    //比倍
    public static  String THAN_TIMES = URL+"thanTimes";
    //比倍选择 （0：押小，1：押大）
    public static  String SURETHANTIMES = URL+"sureThanTimes";
    //得分 getIntegral
    public static  String GETSCORE = URL+"getIntegral";
    //退出
    public static  String EXIT = URL+"exitTheGame";
    //留机或游戏 进入
    public static  String JOINLIVE = URL+"joinLiveGame";
    //留机
    public static  String KEEPGAME = URL+"keepTheGame";
    //退出程序
    public static  String EXITALL= URL+"exitGame";
    //记录
    public static  String RECORD= URL+"record/getMachineRecord";
    //获取中奖信息
    public static  String GET_LUCKY= URL+"message/getMessage";
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
