package hantianyu1504d.bwie.com.avenue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import hantianyu1504d.bwie.com.avenue.homepage.view.HomeFragment;
import hantianyu1504d.bwie.com.avenue.mine.view.MineFragment;
import hantianyu1504d.bwie.com.avenue.nearby.view.NearbyFragment;
import hantianyu1504d.bwie.com.avenue.rebate.view.RebateFragment;
/*
*
* 我的梦 -。  - 我是分支   我写的
*
* 21  写的
*
* */
public class MainActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        home = new HomeFragment();
        addFragment(home);
        mainGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_home:
                        showFragment(home);
                        fg = home;
                        break;
                    case R.id.main_nearby:
                        if (nearby == null) {
                            nearby = new NearbyFragment();
                            addFragment(nearby);
                        }
                        showFragment(nearby);
                        fg = nearby;
                        break;
                    case R.id.main_rebate:
                        rebate = new RebateFragment();
                        addFragment(rebate);

                        showFragment(rebate);
                        fg = rebate;

                        break;
                    case R.id.main_me:
                        if (mine == null) {
                            mine = new MineFragment();
                            addFragment(mine);
                        }
                        showFragment(mine);
                        fg = mine;

                        break;
                }
            }
        });
    }
    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frame, fragment);
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
}
