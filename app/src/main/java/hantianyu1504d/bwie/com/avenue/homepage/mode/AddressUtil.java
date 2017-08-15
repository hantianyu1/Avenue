package hantianyu1504d.bwie.com.avenue.homepage.mode;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/15 14:31
 */
public class AddressUtil {
    private  Context context;
    private  LocationManager locationManager;
    private  String locationProvider;
    private  static final String TAG = "AddressUtil";
    private   Map<String,String>  contextMap=new HashMap<>();
    public AddressUtil(Context context) {
        this.context = context;

        get();
    }

    public  void get(){
        //获取地理位置管理器

        locationManager = (LocationManager)context. getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if(providers.contains(LocationManager.GPS_PROVIDER)){
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(context, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
            return ;
        }
        //获取Location
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if(location!=null){
            //不为空,显示地理位置经纬度
            Map<String, String> map = showLocation(location);
            contextMap.putAll(map);
        }
        //监视地理位置变化

        locationManager.requestLocationUpdates(locationProvider, 3000, 1, locationListener);
    }
    LocationListener locationListener =  new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            //如果位置发生变化,重新显示
            Map<String, String> map = showLocation(location);

        }
    };
    public Map<String,String> getAddress(){
        return contextMap;
    }
    public   Map<String,String> showLocation(Location location){
        Map<String,String>    map=new HashMap<>();
        map.put("longitude",location.getLongitude()+"");
        map.put("latitude",location.getLatitude()+"");
        String locationStr = "维度：" + location.getLatitude() +"\n"
                + "经度：" + location.getLongitude();
        if(contextMap!=null){
            contextMap.clear();
        }
        contextMap.putAll(map);

        return map;
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(locationManager!=null){
//            //移除监听器
//            locationManager.removeUpdates(locationListener);
//        }
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
}
