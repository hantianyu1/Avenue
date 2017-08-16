package hantianyu1504d.bwie.com.avenue.rebate.present;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/16
 */

public interface ICountCashView<T> {
    void onSuccessCount(T t);
    void error(String s);
}
