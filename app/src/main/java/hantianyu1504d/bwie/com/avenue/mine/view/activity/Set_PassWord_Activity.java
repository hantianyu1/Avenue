package hantianyu1504d.bwie.com.avenue.mine.view.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.base.BaseActvitiy;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.PasswordInputView;

/**
 * Created by lichaohui on 2017/8/25.
 * Activity 的懒加载
 */

public class Set_PassWord_Activity extends BaseActvitiy {


    @BindView(R.id.password_view)
    PasswordInputView passwordView;
    @BindView(R.id.rlayout_next)
    RelativeLayout rlayoutNext;

    @Override
    public void initData() {


    }

    @Override
    public void initView() {

    }

    @Override
    public int initContentView() {
        return R.layout.fragment_set_password;
    }


    @OnClick({R.id.rlayout_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rlayout_next:
                String trim = passwordView.getText().toString().trim();
                Toast.makeText(this, "" + trim, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
