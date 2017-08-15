package hantianyu1504d.bwie.com.avenue.port;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 17:36
 * 功能：
 */

public interface RequestDataCallBack<T> {
    //成功
    void SucceedBack(T t);

    //失败
    void ErrBack(String err, int code);
}
