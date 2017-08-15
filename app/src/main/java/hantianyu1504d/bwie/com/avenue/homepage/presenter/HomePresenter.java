package hantianyu1504d.bwie.com.avenue.homepage.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.UrlServer;
import hantianyu1504d.bwie.com.avenue.homepage.mode.HomeView;
import hantianyu1504d.bwie.com.avenue.homepage.mode.NearShopsBean;
import hantianyu1504d.bwie.com.avenue.homepage.mode.PagerAndShopsBean;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/11 19:56
 */
public class HomePresenter {
    private HomeView homeView;
    private static final String TAG = "HomePresenter";
    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }
    public void getDateBanner( ){
        HttpUtils httpUtils=new HttpUtils(new HttpUtils.RealCall() {
            @Override
            public void onSuessce(Object tClass) {
                PagerAndShopsBean bean= (PagerAndShopsBean) tClass;
                homeView.upDate(bean);
//                Log.e(TAG, "onSuessce: "+ bean.getCode()+bean.getObject().getTotalSize());
            }

            @Override
            public void onError(String str) {
                Log.e(TAG, "onError: "+str );
            }
        });
        Map<String,String> map=new HashMap<>();
        map.put("type","0");
        httpUtils.loadDataFromServerPost(UrlServer.BASE_URL+UrlServer.PAGEANDSHPOSURL,map, PagerAndShopsBean.class);
    }
    public void getDateShops( ){
        HttpUtils httpUtils=new HttpUtils(new HttpUtils.RealCall() {
            @Override
            public void onSuessce(Object tClass) {
                PagerAndShopsBean bean= (PagerAndShopsBean) tClass;
                homeView.upDate(bean);
                Log.e(TAG, "onSuessce: "+ bean.getCode()+bean.getObject().getTotalSize());
            }

            @Override
            public void onError(String str) {
                Log.e(TAG, "onError: "+str );
            }
        });
        Map<String,String> map=new HashMap<>();
        map.put("type","0");
        httpUtils.loadDataFromServerPost(UrlServer.BASE_URL+UrlServer.PAGEANDSHPOSURL,map, PagerAndShopsBean.class);
    }
    public void getAddress( Map<String,String> map){
        HttpUtils httpUtils=new HttpUtils(new HttpUtils.RealCall() {
            @Override
            public void onSuessce(Object tClass) {
                NearShopsBean bean= (NearShopsBean) tClass;
                homeView.upAddressDate(bean);

            }

            @Override
            public void onError(String str) {
                Log.e(TAG, "onError: "+str );
            }
        });

        httpUtils.loadDataFromServerPost(UrlServer.BASE_URL+UrlServer.NEARSHOPS,map, NearShopsBean.class);
    }
}
