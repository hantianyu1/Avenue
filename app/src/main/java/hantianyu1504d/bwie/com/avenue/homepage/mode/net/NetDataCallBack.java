package hantianyu1504d.bwie.com.avenue.homepage.mode.net;

/**
 * Created by lichaohui on 2017/8/11.
 */

public interface NetDataCallBack<T> {
    void sccessCallBack(T t);

    void errCallBack(String err, int code);
}
