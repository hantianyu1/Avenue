package hantianyu1504d.bwie.com.avenue.core.utils;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类描述：
 * 创建人：张海顺
 * 班级：1504D
 * 创建时间：2017/8/4 22:00.
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils";
    private RealCall realCall;

    public HttpUtils(RealCall realCall) {
        this.realCall = realCall;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Object obj = msg.obj;
                    realCall.onSuessce(obj);
                    break;
                case 1:
                    realCall.onError( msg.obj.toString());
                    break;
            }
        }
    };

    public <T> void loadDataFromServerGet( String url,  final Class<T> tClass) {

        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
        Request request=new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        final Message message = handler.obtainMessage();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what = 1;
                message.obj = e.getMessage().toString();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.what = 0;
                Gson gson=new Gson();
                message.obj =  gson.fromJson(response.body().string(), tClass);
                handler.sendMessage(message);
            }
        });

    }

    public <T> void loadDataFromServerPost( String url, Map<String, String> map, final Class<T> tClass) {
        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> set:entries) {
            builder.add(set.getKey(),set.getValue());
        }

        Request request=new Request.Builder().post(builder.build()).url(url).build();
        Call call = okHttpClient.newCall(request);
        final Message message = handler.obtainMessage();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what = 1;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.what = 0;
                Gson gson=new Gson();
                message.obj =  gson.fromJson(response.body().string(), tClass);
                handler.sendMessage(message);
            }
        });
    }
    public interface RealCall<T>{
        void onSuessce(T tClass);
        void onError(String str);
    }

}
