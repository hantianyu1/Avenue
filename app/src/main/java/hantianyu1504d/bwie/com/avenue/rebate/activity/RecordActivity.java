package hantianyu1504d.bwie.com.avenue.rebate.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.adapter.RecordAdapter;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.RecordFragment;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.SecordFragment;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.WaitFragment;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecordActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        initData();
    }
    private void initData() {
        RecordFragment myFragment = new RecordFragment();
        SecordFragment secordFragment=new SecordFragment();
        WaitFragment waitFragment=new WaitFragment();
        fragmentList.add(myFragment);
        fragmentList.add(secordFragment);
        fragmentList.add(waitFragment);
        list.add("积分记录");
        list.add("已返利");
        list.add("待返利");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(2)));
        RecordAdapter adapter=new RecordAdapter(getSupportFragmentManager(),fragmentList,list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
