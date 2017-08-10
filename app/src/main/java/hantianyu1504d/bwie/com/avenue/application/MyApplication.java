package hantianyu1504d.bwie.com.avenue.application;

import android.app.Application;

import hantianyu1504d.bwie.com.avenue.core.utils.CrashHandler;


/**
 * Created by lichaohui on 2017/8/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 全局异常处理
        CrashHandler.getInstance().init(this, true);
    }
}
