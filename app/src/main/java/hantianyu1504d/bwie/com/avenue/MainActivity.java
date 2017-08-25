package hantianyu1504d.bwie.com.avenue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import hantianyu1504d.bwie.com.avenue.application.MyApplication;
import hantianyu1504d.bwie.com.avenue.homepage.view.HomeFragment;
import hantianyu1504d.bwie.com.avenue.mine.view.fragment.MineFragment;
import hantianyu1504d.bwie.com.avenue.nearby.view.NearbyFragment;
import hantianyu1504d.bwie.com.avenue.rebate.view.RebateFragment;

public class MainActivity extends AppCompatActivity {
    //
    @BindView(R.id.main_home)
    RadioButton mainHome;
    @BindView(R.id.main_nearby)
    RadioButton mainNearby;
    @BindView(R.id.main_rebate)
    RadioButton mainRebate;
    @BindView(R.id.main_me)
    RadioButton mainMe;
    @BindView(R.id.main_group)
    RadioGroup mainGroup;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    private Fragment fg;
    private HomeFragment home;
    private NearbyFragment nearby;
    private RebateFragment rebate;
    private MineFragment mine;
    private boolean isExit;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments = new ArrayList<>();
        home = new HomeFragment();
        nearby = new NearbyFragment();
        rebate = new RebateFragment();
        mine = new MineFragment();
        fragments.add(home);
        fragments.add(nearby);
        fragments.add(rebate);
        fragments.add(mine);
        addFragment(home);
        addFragment(nearby);
        addFragment(rebate);
        addFragment(mine);
        mainGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_home:
//                        showFragment(home);
//                        fg = home;
                        showHideFragment(0);
                        break;
                    case R.id.main_nearby:
//                        if (nearby == null) {
//                            nearby = new NearbyFragment();
//                            addFragment(nearby);
//                        }
//                        showFragment(nearby);
//                        fg = nearby;
                        showHideFragment(1);
                        break;
                    case R.id.main_rebate:
//                        rebate = new RebateFragment();
//                        addFragment(rebate);
//
//                        showFragment(rebate);
//                        fg = rebate;
                        showHideFragment(2);
                        break;
                    case R.id.main_me:
//                        if (mine == null) {
//                            mine = new MineFragment();
//                            addFragment(mine);
//                        }
//                        showFragment(mine);
//                        fg = mine;
                        showHideFragment(3);
                        break;
                }
            }
        });
        showHideFragment(0);
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frame, fragment);
        transaction.commit();
    }

    private void showHideFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < 4; i++) {
            transaction = (i == index) ? transaction.show(fragments.get(i))
                    : transaction.hide(fragments.get(i));
        }
        transaction.commit();
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fg != null) {
            transaction.hide(fg);
        }
        transaction.show(fragment);
        transaction.commit();
        fg = null;
    }

    //单击返回键两次退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit == false) {
                isExit = true;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            } else {
                MyApplication.getInstance().exitApp();
            }
        }
        return false;
    }


}
