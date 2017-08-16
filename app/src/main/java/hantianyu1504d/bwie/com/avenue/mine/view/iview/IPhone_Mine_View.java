package hantianyu1504d.bwie.com.avenue.mine.view.iview;

/**
 * Created by lichaohui on 2017/8/3.
 */

public interface IPhone_Mine_View<T> {
    void sccessCallBack(T t, String str);

    void errCallBack(String err, int code);

}
