package com.blyy.game.tigermachinegame.thread;


import android.os.Handler;

/**
 * Created by WuJingCheng on 2018/4/18.
 */

public class ThreadHold implements Runnable{
    private boolean change = false;
    private Handler handler;
    private volatile boolean stop=false;//此变量必须加上volatile
    public ThreadHold(Handler handler) {
        this.handler = handler;
    }
    public void stop(){
        stop =true;
    }
    @Override
    public void run() {
        while (!stop) {
            try {
                if (change) {
                    change = false;
                    handler.sendEmptyMessage(14);
                } else {
                    change = true;
                    handler.sendEmptyMessage(15);
                }
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
