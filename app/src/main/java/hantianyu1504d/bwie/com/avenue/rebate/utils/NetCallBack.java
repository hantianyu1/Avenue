package hantianyu1504d.bwie.com.avenue.rebate.utils;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public interface NetCallBack<T> {
    void success(T t);
    void error(int code,String s);
}
