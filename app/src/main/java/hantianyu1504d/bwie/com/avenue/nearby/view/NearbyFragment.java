package hantianyu1504d.bwie.com.avenue.nearby.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import java.util.ArrayList;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.nearby.adapter.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * 附近页面
 */
public class NearbyFragment extends Fragment {
    private List<String> str_list = new ArrayList<>();
    private List<Fragment> frag_list = new ArrayList<>();
    private View view;
    private MapView map;
    private BaiduMap baiduMap;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CollapsingToolbarLayout ctb;
    private AppBarLayout layout_appbar;
    private Toolbar toolbar;
    private ViewPagerAdapter vpadapter;

    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = inflater.inflate(R.layout.fragment_nearby, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        map = (MapView) view.findViewById(R.id.nearby_map);
        initMap();
        ctb = (CollapsingToolbarLayout) view.findViewById(R.id.ctb);
        layout_appbar = (AppBarLayout) view.findViewById(R.id.layout_appbar);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initToolbar();
        tabLayout = (TabLayout) view.findViewById(R.id.foot_tab);
        viewPager = (ViewPager) view.findViewById(R.id.foot_viewpaer);
        initFootMain();


    }

    private void initFootMain() {
        str_list.add("美食");
        str_list.add("休闲娱乐");
        str_list.add("生活服务");
        str_list.add("酒店");
        str_list.add("全部 ");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        frag_list.clear();
        for (int i = 0; i < str_list.size(); i++) {
            ViewPagerFragment vpFragment = new ViewPagerFragment();
            frag_list.add(vpFragment);
        }
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Toolbar 设置折叠
     */
    private void initToolbar() {
        //        toolbar.setLogo(R.mipmap.ic_launcher);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //CollapsingToolbarLayout作用是提供了一个可以折叠的Toolbar
        //给左上角图标的左边加上一个返回的图标
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //这里要注意的就是需要将setSupportActionBar(toolbar)放在setNavigationOnClickListener()之前设置才行。
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //相当于获取Back键的按下事件
                ((AppCompatActivity) getActivity()).onBackPressed();
            }
        });
        //设置文字
        ctb.setTitle("");
        //设置收缩展开toolbar字体颜色
        ctb.setExpandedTitleColor(Color.WHITE);
        ctb.setCollapsedTitleTextColor(Color.BLACK);
    }

    /**
     * 百度地图
     */
    private void initMap() {
        baiduMap = map.getMap();
        //普通地图
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        // 隐藏logo
        View child = map.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //隐藏放大缩小图标
        map.showZoomControls(false);
    }


}
