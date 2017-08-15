package hantianyu1504d.bwie.com.avenue.rebate.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecordAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> list;

    public RecordAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> list) {
        super(fm);
        this.fragmentList = fragmentList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position %list.size());
    }
}
