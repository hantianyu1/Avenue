package hantianyu1504d.bwie.com.avenue.nearby.persebter;

import android.util.Log;

import hantianyu1504d.bwie.com.avenue.base.BasePresenter;
import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.OkHttpUtils;
import hantianyu1504d.bwie.com.avenue.port.IMainView;
import hantianyu1504d.bwie.com.avenue.port.RequestDataCallBack;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 21:47
 * 功能：
 */

public class ShopPersebter<T> extends BasePresenter<IMainView> {
    private OkHttpUtils httpUtils;
    private static final String TAG = "MainPresenter";
    private int code;

    public <T> void load_data(String url, Class<T> tClass) {
        httpUtils = new OkHttpUtils();
        httpUtils.request_data(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(T o) {
                getMvpView().SucceedCallBack(o);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass);
    }

}
