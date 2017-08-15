package hantianyu1504d.bwie.com.avenue.nearby.vp_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/8/13 21:22
 * 功能：附近页面商品详情页面的ViewPager 的适配器
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> title_List;
    private List<Fragment> frag_List;

    public ViewPagerAdapter(FragmentManager fm, List<String> title_List, List<Fragment> frag_List) {
        super(fm);
        this.frag_List = frag_List;
        this.title_List = title_List;
    }

    @Override
    public Fragment getItem(int position) {
        return frag_List.get(position);
    }

    @Override
    public int getCount() {
        return frag_List.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_List.get(position);
    }
}
