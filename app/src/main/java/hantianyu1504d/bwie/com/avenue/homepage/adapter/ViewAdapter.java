package hantianyu1504d.bwie.com.avenue.homepage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/8/17 20:43
 * 功能：ViewPager
 */

public class ViewAdapter extends FragmentPagerAdapter {
    private List<String> Slist;
    private List<Fragment> Flist;

    public ViewAdapter(FragmentManager fm, List<String> Slist, List<Fragment> Flist) {
        super(fm);
        this.Slist = Slist;
        this.Flist = Flist;
    }

    @Override
    public Fragment getItem(int position) {
        return Flist.get(position);
    }

    @Override
    public int getCount() {
        return Flist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Slist.get(position);
    }
}
