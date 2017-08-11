package hantianyu1504d.bwie.com.avenue.homepage.presener;

/**
 * Created by lichaohui on 2017/8/3.
 */

public class BasePresener<V> {

    private V v;

    public void attachView(V v) {
        this.v = v;
    }

    public V getView() {
        return v;
    }

    public void dettachView() {
        v = null;
    }


}
