package hantianyu1504d.bwie.com.avenue.base;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 16:57
 * 功能：
 */

public class BasePresenter<V> {
    private V mV;

    //给传过来的值赋值
    public void attachView(V v) {
        this.mV = v;
    }

    //返回传过来的值
    public V getMvpView() {
        return mV;
    }

    //制空
    public void dettachView() {
        mV = null;
    }

}
