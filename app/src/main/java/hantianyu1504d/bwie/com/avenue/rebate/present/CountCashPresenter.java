package hantianyu1504d.bwie.com.avenue.rebate.present;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/16
 */

public class CountCashPresenter<T> implements HttpUtils.RealCall<T>{
      private  ICountCashView iCountCashView;

      public CountCashPresenter(ICountCashView iCountCashView) {
            this.iCountCashView=iCountCashView;
      }

      public  <T>void getCount(String url, HashMap<String,String> map, Class<T> tClass){
            HttpUtils httpUtils=new HttpUtils();
            httpUtils.setRealCall(this);
            httpUtils.loadDataFromServerPost(url,map,tClass);
      }

      @Override
      public void onSuessce(T tClass) {
            iCountCashView.onSuccessCount(tClass);
      }

      @Override
      public void onError(String str) {

      }
}
