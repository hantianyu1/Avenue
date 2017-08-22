package hantianyu1504d.bwie.com.avenue.homepage.presenter;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.UrlServer;
import hantianyu1504d.bwie.com.avenue.homepage.mode.CategoriesBean;
import hantianyu1504d.bwie.com.avenue.homepage.mode.HomeView;


/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/12 11:41
 */
public class MiddlePagerPresenter {
    private HomeView homeView;
    private String pageNum;
    public MiddlePagerPresenter(HomeView homeView) {
        this.homeView = homeView;
    }
    public void upMiddleDate(String s){
        HttpUtils httpUtils=new HttpUtils(new HttpUtils.RealCall<CategoriesBean>() {
            @Override
            public void onSuessce(CategoriesBean bean) {
                homeView.upDate(bean);
            }

            @Override
            public void onError(String str) {

            }
        });
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum",s);
        httpUtils.loadDataFromServerPost(UrlServer.BASE_URL+UrlServer.CATEGORIESURL,map, CategoriesBean.class);
    }


}