package hantianyu1504d.bwie.com.avenue.homepage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/12 11:05
 */
public class MiddlePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MiddlePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);

        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int arg0) {

        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {

        return mFragments.size();
    }

}
