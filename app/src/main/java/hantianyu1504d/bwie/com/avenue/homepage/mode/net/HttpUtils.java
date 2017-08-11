package hantianyu1504d.bwie.com.avenue.homepage.mode.net;


import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lichaohui on 2017/8/11.
 */

public class HttpUtils {

    private static volatile HttpUtils instant;
    private NetDataCallBack netDataCallBack;
    private OkHttpClient okHttpClient;

    private HttpUtils() {
        if (instant != null) {
            throw new RuntimeException("只能运行一个啊！！！");
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                // get
                case 1:
                    if (netDataCallBack != null) {
                        netDataCallBack.sccessCallBack(msg.obj);
                    }
                    break;
                // get
                case 2:
                    if (netDataCallBack != null) {
                        netDataCallBack.sccessCallBack(msg.obj);
                    }
                    break;

            }
        }
    };

    public static HttpUtils getInstant() {
        if (instant == null) {
            synchronized (HttpUtils.class) {
                if (instant == null) {
                    instant = new HttpUtils();
                }
            }
        }
        return instant;
    }

    public <T> void loadDataCallBack( final String str, NetDataCallBack netDataCallBack, final Class<T> clas) {
        this.netDataCallBack = netDataCallBack;
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
                Request build = new Request.Builder().url(str)
                        .build();
                Call call = okHttpClient.newCall(build);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            ResponseBody body = response.body();
                            String string = body.string();
                            Gson gson = new Gson();
                            T t = gson.fromJson(string, clas);
                            Message message = handler.obtainMessage();
                            message.obj = t;
                            message.what = 1;
                            handler.sendMessage(message);
                        }
                    }
                });
    }


    public <T> void loadDataPostCallBack(final String str, HashMap<String, String> map, NetDataCallBack netDataCallBack, final Class<T> clas) {
        this.netDataCallBack = netDataCallBack;
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
        HttpUtil.doPost(str, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    Gson gson = new Gson();
                    T t = gson.fromJson(string, clas);
                    Message message = handler.obtainMessage();
                    message.obj = t;
                    message.what = 2;
                    handler.sendMessage(message);
                }
            }
        });

    }


}
