package com.blyy.game.tigermachinegame.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.activity.App;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by WuJingCheng
 * on 2018/2/9.
 */
public class OkHttpUtils {
    public static <T> void getData(final Activity activity, String url, RequestBody requestBody,
                                   final Class<T> tClass, final Handler handler, final int handlerCode){
        App.getApp().showDialog(activity);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8")
                .addHeader("cookie",Constans.Session==null?"":Constans.Session)
                .post(requestBody)
                .build();
        Call call =client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              activity.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      App.getApp().dissmissDialog();
                      App.getApp().showTipsDialog(activity);
                  }
              });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                App.getApp().dissmissDialog();
                String msg = response.body().string();
                Constans.showLogCompletion(msg,3000);
                System.out.println(msg);
                if(response.isSuccessful()){
                    Message message = new Message();
                    message.what = handlerCode;
                    message.obj = JsonUtil.getJsonBean(tClass,msg);
                    handler.sendMessage(message);
                    if(Constans.Session==null){//获取session的操作
                        try {
                            Headers headers = response.headers();
                            Log.d("info_headers", "header " + headers);
                            List<String> cookies = headers.values("Set-Cookie");
                            String session = cookies.get(0);
                            Log.d("info_cookies", "onResponse-size: " + cookies);
                            Constans.Session = session.substring(0, session.indexOf(";"));
                            Log.e("info_s", "session is  :" + Constans.Session);
                        }catch (Exception r){

                        }

                    }

                }else {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity,"请求错误",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
