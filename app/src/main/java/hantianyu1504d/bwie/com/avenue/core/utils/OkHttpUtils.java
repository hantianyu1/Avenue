package hantianyu1504d.bwie.com.avenue.core.utils;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import hantianyu1504d.bwie.com.avenue.port.RequestDataCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 17:30
 * 功能：Okhttp的请求工具类
 */

public class OkHttpUtils {

    private static final String TAG = "HttpUtils";
    private RequestDataCallBack requestDataCallBack;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    requestDataCallBack.SucceedBack(msg.obj);
                    break;
                case 1:
                    requestDataCallBack.SucceedBack(msg.obj);
                    break;
            }
        }
    };
    /**
     * 定义请求数据
     *
     * @param url
     * @param requestDataCallBack
     * @param tClass
     * @param <T>
     */
    public <T> void request_data(String url, final RequestDataCallBack requestDataCallBack, final Class<T> tClass) {
        this.requestDataCallBack = requestDataCallBack;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //netDataCallback.err(500,e.getMessage());
//                Log.e("=====", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.what = 0;
                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), tClass);
//                Log.e(TAG, "onResponse: " + t);
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }
}
