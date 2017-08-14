package hantianyu1504d.bwie.com.avenue.rebate.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class OkHttpUtils {
       private NetCallBack net;
           private Handler handler = new Handler() {
               @Override
               public void handleMessage(Message msg) {
                   super.handleMessage(msg);
                   switch (msg.what) {
                       case 0:
                           net.success(msg.obj);
                           break;
                       case 1:
                           net.error(400,(String) msg.obj);
                           break;
                   }
               }
           };

           public <T>void LoadData(String url, NetCallBack net,final Class<T> tClass) {
               this.net = net;
               OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
               Request request = new Request.Builder()
                       .url(url)
                       .build();
               Call call = okHttpClient.newCall(request);
               call.enqueue(new Callback() {
                   @Override
                   public void onFailure(Call call, IOException e) {
                       Message msg = Message.obtain();
                       msg.what = 1;
                       msg.obj = e.getMessage().toString();
                       handler.sendMessage(msg);
                   }

                   @Override
                   public void onResponse(Call call, Response response) throws IOException {
                       Message msg = Message.obtain();
                       Gson gson = new Gson();
                       String string = response.body().string();
                       Log.e("str", "onResponse: " + string);
                       T t = gson.fromJson(string, tClass);
                       msg.obj = t;
                       msg.what=0;
                       handler.sendMessage(msg);
                   }
               });
           }
}
