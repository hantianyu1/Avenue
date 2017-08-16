package hantianyu1504d.bwie.com.avenue.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.MyApplication;

/**
 * Created by lichaohui on 2017/8/3.
 */

public abstract class BaseActvitiy extends AppCompatActivity {
    private Unbinder bind;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //acticity跳转动画——右进左出
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        setContentView(initContentView());
        /*View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
*/
        mContext = this;
        bind = ButterKnife.bind(this);
        initView();
        initData();

        MyApplication.getInstance().addActivity(this);
    }

    public abstract void initData();

    public abstract void initView();

    public abstract int initContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            //ButterKnift解除绑定
            bind.unbind();
        }
        //删除当前Activity
        MyApplication.getInstance().removeActivity(this);
    }
}
