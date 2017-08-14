package hantianyu1504d.bwie.com.avenue.rebate.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.AlreadyFragment;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.RecordFragment;
import hantianyu1504d.bwie.com.avenue.rebate.fragment.WaitFragment;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecordActivity extends AppCompatActivity {

    @BindView(R.id.img_return)
    ImageView imgReturn;
    @BindView(R.id.radio_record)
    RadioButton radioRecord;
    @BindView(R.id.radio_already)
    RadioButton radioAlready;
    @BindView(R.id.radio_wait)
    RadioButton radioWait;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.record_frame)
    FrameLayout recordFrame;
    private Fragment fg;
    RecordFragment recordFragment;
    AlreadyFragment alreadyFragment;
    WaitFragment waitFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        recordFragment=new RecordFragment();
        addFragment(recordFragment);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_record:
                        showFragment(recordFragment);
                        fg = recordFragment;
                        Toast.makeText(RecordActivity.this,"积分记录",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_already:
                        if(alreadyFragment==null){
                            alreadyFragment = new AlreadyFragment();
                            addFragment(alreadyFragment);
                        }

                        showFragment(alreadyFragment);
                        fg = alreadyFragment;

                        Toast.makeText(RecordActivity.this,"已返利",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_wait:
                        if(waitFragment==null){
                            waitFragment=new WaitFragment();
                            addFragment(waitFragment);
                        }
                        showFragment(waitFragment);
                        fg = waitFragment;
                        Toast.makeText(RecordActivity.this,"待返利",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @OnClick(R.id.img_return)
    public void onViewClicked() {
        RecordActivity.this.finish();
    }


    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.record_frame, fragment);
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
