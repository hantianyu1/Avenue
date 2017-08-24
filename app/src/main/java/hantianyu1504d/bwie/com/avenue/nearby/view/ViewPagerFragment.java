package hantianyu1504d.bwie.com.avenue.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.nearby.adapter.ViewPagerFragmentAdapter;
import hantianyu1504d.bwie.com.avenue.nearby.bean.SBean;
import hantianyu1504d.bwie.com.avenue.nearby.bean.ShopBean;
import hantianyu1504d.bwie.com.avenue.nearby.persebter.ShopPersebter;
import hantianyu1504d.bwie.com.avenue.port.INearbyView;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/15 20:07
 */
public class ViewPagerFragment extends Fragment implements INearbyView<SBean> {

    private View view;
    private RecyclerView nearby_shop_recycler;
    private String url = "http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1";
    private List<SBean.DataBean> list = new ArrayList<>();
    private List<ShopBean.ObjectBean.ListBean> shoplist = new ArrayList<>();
    private ViewPagerFragmentAdapter adapter;
    private ShopPersebter persebter;
    private String str = "http://123.57.33.185:8088/near/shops";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.nearby_shop_recyclerview, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        nearby_shop_recycler = (RecyclerView) view.findViewById(R.id.nearby_shop_recycler);
        adapter = new ViewPagerFragmentAdapter(getActivity(), list);
        nearby_shop_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        nearby_shop_recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        nearby_shop_recycler.setAdapter(adapter);

    }


    private void initData() {
        persebter = new ShopPersebter();
        persebter.attachView(this);
        persebter.load_data(url, SBean.class);
//        longitude=116.4192930000
//                &
//                latitude=39.9768360000
//                &
//                categoryType=
//                1 - 美食
//        7 - 休闲娱乐
//        5 - 生活服务
//        2 - 酒店

//        Map<String, String> map = new HashMap<>();
//        map.put("longitude", "116.4192930000");
//        map.put("latitude", "39.9768360000");
//        map.put("categoryType", "5");
//        persebter.load_post(str, map, ShopBean.class);


    }

    @Override
    public void SucceedCallBack(SBean sBean) {
        List<SBean.DataBean> data = sBean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ErrCallBack(String str, int code) {

    }

   /* @Override
    public void SucceedCallBack(ShopBean shopBean) {
        List<ShopBean.ObjectBean.ListBean> ListBean = shopBean.getObject().getList();
        shoplist.addAll(ListBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ErrCallBack(String str, int code) {

    }*/

}
