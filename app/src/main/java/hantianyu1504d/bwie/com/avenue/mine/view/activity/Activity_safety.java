package hantianyu1504d.bwie.com.avenue.mine.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.base.BaseActvitiy;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;

/**
 * Created by lichaohui on 2017/8/14.
 */

public class Activity_safety extends BaseActvitiy {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_safe_reset_login)
    TextView txtSafeResetLogin;
    @BindView(R.id.txt_safe_reset_payment)
    TextView txtSafeResetPayment;
    @BindView(R.id.txt_safe_reset_password)
    TextView txtSafeResetPassword;
    @BindView(R.id.txt_safe_reset_phone)
    TextView txtSafeResetPhone;
    @BindView(R.id.txt_safe_exit)
    RadioButton txtSafeExit;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public int initContentView() {
        return R.layout.safe_seting_mine;
    }


    @OnClick({R.id.img_back, R.id.txt_safe_reset_login, R.id.txt_safe_reset_payment, R.id.txt_safe_reset_password, R.id.txt_safe_reset_phone, R.id.txt_safe_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回
            case R.id.img_back:
                finish();
                break;
            //重置登录密码
            case R.id.txt_safe_reset_login:

                break;
            // 重置支付 密码
            case R.id.txt_safe_reset_payment:

                break;
            //重置手势密码
            case R.id.txt_safe_reset_password:

                break;
            //更换手机号
            case R.id.txt_safe_reset_phone:
                startActivity(new Intent(mContext, Phone_Mine_Activity.class));
                break;
            // 退出登录
            case R.id.txt_safe_exit:
                // 清除 sp 记录
                SPUtil.put(mContext,Canstant.anim.MINE_KEY,"");
                SPUtil.remove(mContext,Canstant.anim.MINE_KEY);
                Toast.makeText(this, "已经退出登录！！！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
