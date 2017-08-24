package hantianyu1504d.bwie.com.avenue.application;

import android.app.Activity;
import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

import java.util.HashSet;
import java.util.Set;

import hantianyu1504d.bwie.com.avenue.core.utils.CrashHandler;


/**
 * Created by lichaohui on 2017/8/10.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private Set<Activity> allActivities;

    public static synchronized MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 全局异常处理
        CrashHandler.getInstance().init(this, true);
        //百度地图SDK
        SDKInitializer.initialize(getApplicationContext());
    }


    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        System.exit(0);
    }

}
