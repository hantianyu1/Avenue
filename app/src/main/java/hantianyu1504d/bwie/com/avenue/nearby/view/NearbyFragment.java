package hantianyu1504d.bwie.com.avenue.nearby.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;

import java.util.ArrayList;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.baidumap.MyLocationListener;
import hantianyu1504d.bwie.com.avenue.nearby.adapter.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * 附近页面  ssss
 */
public class NearbyFragment extends Fragment {
    private List<String> str_list = new ArrayList<>();
    private List<Fragment> frag_list = new ArrayList<>();
    private View view;
    private MapView map;
    private BaiduMap baiduMap;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LocationClient mLocationClient;
    private MyLocationConfiguration.LocationMode mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
    private BDLocationListener myListener;

    /*BDAbstractLocationListener为7.2版本新增的Abstract类型的监听接口，原有BDLocationListener接口暂时同步保留。具体介绍请参考后文中的说明*/
    public NearbyFragment() {
        // Required empty public constructor
    }
//    BDAbstractLocationListener

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nearby, container, false);
        initView();
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener((BDLocationListener) myListener);
        initLocation();
        //注册监听函数
        mLocationClient.start();
        return view;
    }


    private void initView() {
        map = (MapView) view.findViewById(R.id.nearby_map);
        initMap();
        tabLayout = (TabLayout) view.findViewById(R.id.foot_tab1);
        viewPager = (ViewPager) view.findViewById(R.id.foot_viewpaer1);
        initFootMain();

    }

    /**
     * 百度地图  初始化定位相关代码
     */
    private void initMap() {
        baiduMap = map.getMap();
        myListener = new MyLocationListener(baiduMap);
        //普通地图
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        // 隐藏logo
        View child = map.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
     /*//隐藏放大缩小图标
        map.showZoomControls(false);*/
//        // 设置可改变地图位置
//        baiduMap.setMyLocationEnabled(true);
    }

    /**
     * 百度地图 SDK的官方配置
     */
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span = 1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

//        option.setIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

//        option.setWifiValidTime(5*60*1000);
        //可选，7.2版本新增能力，如果您设置了这个接口，首次启动定位时，会先判断当前WiFi是否超出有效期，超出有效期的话，会先重新扫描WiFi，然后再定位

        mLocationClient.setLocOption(option);
    }

    /**
     * 设置tablayout和ViewPager的数据
     */
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
        ViewPagerAdapter viewAdapter = new ViewPagerAdapter(getFragmentManager(), str_list, frag_list);
        viewPager.setAdapter(viewAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
