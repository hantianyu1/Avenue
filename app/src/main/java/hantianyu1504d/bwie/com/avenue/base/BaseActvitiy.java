package hantianyu1504d.bwie.com.avenue.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichaohui on 2017/8/3.
 */

public abstract class BaseActvitiy extends AppCompatActivity {

    private Unbinder bind;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initContentView());
        // 沉浸式
     /*   View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
        mContext = this;
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract void initData();

    public abstract void initView();

    public abstract int initContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
