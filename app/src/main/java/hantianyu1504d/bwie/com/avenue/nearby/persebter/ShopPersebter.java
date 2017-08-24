package hantianyu1504d.bwie.com.avenue.nearby.persebter;

import java.util.Map;

import hantianyu1504d.bwie.com.avenue.base.BasePresenter;
import hantianyu1504d.bwie.com.avenue.core.utils.OkHttpUtils;
import hantianyu1504d.bwie.com.avenue.port.INearbyView;
import hantianyu1504d.bwie.com.avenue.port.RequestDataCallBack;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 21:47
 * 功能：附近商铺的P层
 */

public class ShopPersebter<T> extends BasePresenter<INearbyView> {
    private OkHttpUtils httpUtils;
    private static final String TAG = "ShopPersebter";

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

    public <T> void load_post(String url,Map < String, String > Pmap, Class<T> tClass) {
        httpUtils = new OkHttpUtils();
        httpUtils.postAsynHttpLogin(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(T t) {
                getMvpView().SucceedCallBack(t);
            }

            @Override
            public void ErrBack(String err, int code) {

            }

        },tClass,Pmap);
    }
}
