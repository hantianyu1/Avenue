package hantianyu1504d.bwie.com.avenue.port;

/**
 * 作者：李飞宇
 * 时间：2017/8/17 15:39
 * 功能：
 */

public interface INearbyView <T> {
    //成功
    void SucceedCallBack(T t);

    //失败
    void ErrCallBack(String str, int code);
}