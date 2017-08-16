package hantianyu1504d.bwie.com.avenue.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hantianyu1504d.bwie.com.avenue.R;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/15 20:07
 */
public class ViewPagerFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=View.inflate(getActivity(), R.layout.nearby_shop_recyclerview,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
