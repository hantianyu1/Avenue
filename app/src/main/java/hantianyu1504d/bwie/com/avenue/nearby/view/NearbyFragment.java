package hantianyu1504d.bwie.com.avenue.nearby.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;

import hantianyu1504d.bwie.com.avenue.R;


/**
 * A simple {@link Fragment} subclass.
 * 附近页面
 */
public class NearbyFragment extends Fragment {

    private View view;
    private MapView map;
    private BaiduMap baiduMap;
    private MyLocationConfiguration.LocationMode mCurrentMode;

    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = inflater.inflate(R.layout.fragment_nearby, container, false);
        initView();
        return view;
    }

    private void initView() {
        map = (MapView) view.findViewById(R.id.nearby_map);
        baiduMap = map.getMap();
        //普通地图
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
