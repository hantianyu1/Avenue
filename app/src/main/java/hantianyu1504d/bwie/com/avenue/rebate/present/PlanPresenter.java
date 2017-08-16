package hantianyu1504d.bwie.com.avenue.rebate.present;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;

/**
 * 类的作用:返利计划的p层
 * author: 刘婕
 * date:2017/8/16
 */

public class PlanPresenter<T> implements HttpUtils.RealCall<T>{
      private  IPlanView iPlanView;

      public PlanPresenter(IPlanView iPlanView) {
            this.iPlanView=iPlanView;
      }

      public  <T>void getPlan(String url, HashMap<String,String> map, Class<T> tClass){
            HttpUtils httpUtils=new HttpUtils();
            httpUtils.setRealCall(this);
            httpUtils.loadDataFromServerPost(url,map,tClass);
      }

      @Override
      public void onSuessce(T tClass) {
            iPlanView.onSuccess(tClass);

      }

      @Override
      public void onError(String str) {

      }
}
