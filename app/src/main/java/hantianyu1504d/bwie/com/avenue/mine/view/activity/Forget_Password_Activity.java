package hantianyu1504d.bwie.com.avenue.mine.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.base.BaseActvitiy;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.Note;
import hantianyu1504d.bwie.com.avenue.mine.mode.utils.CommonUtils;
import hantianyu1504d.bwie.com.avenue.mine.mode.utils.TimeCount;
import hantianyu1504d.bwie.com.avenue.mine.presener.Login_Presener;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IMainView;

/**
 * Created by lichaohui on 2017/8/14.
 * 10   --
 * 14 -6-    2017 9
 */

public class Forget_Password_Activity extends BaseActvitiy implements IMainView {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.edt_forget_phone)
    EditText edtForgetPhone;
    @BindView(R.id.edt_forget_verify)
    EditText edtForgetVerify;
    @BindView(R.id.rbtn_forget_gaincode)
    Button rbtnForgetGaincode;
    @BindView(R.id.edt_forget_out_password)
    EditText edtForgetOutPassword;
    @BindView(R.id.img_forget_hindpassword)
    ImageView imgForgetHindpassword;
    @BindView(R.id.edt_forget_confim_password)
    EditText edtForgetConfimPassword;
    @BindView(R.id.rbtn_forget_reset_password)
    RadioButton rbtnForgetResetPassword;
    private Login_Presener login_presener;
    private boolean isboo;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        login_presener = new Login_Presener();
        login_presener.attachView(this);
    }

    @Override
    public int initContentView() {
        return R.layout.forget_password_mine;
    }

    @OnClick({R.id.img_back, R.id.rbtn_forget_gaincode, R.id.newpassworld_image, R.id.img_forget_hindpassword, R.id.rbtn_forget_reset_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 返回当前页面
            case R.id.img_back:
                finish();
                break;
            //获取验证码 0 登录  1 注册  2 找回密码
            case R.id.rbtn_forget_gaincode:
                // 防止多少点击
                if (CommonUtils.isFastDoubleClick()) {
                    return;
                }
                String phone1 = edtForgetPhone.getText().toString().trim();
                // 号码格式不正确
                boolean b = login_presener.Login_Post_Presener(2, phone1, mContext, Note.class);
                break;
            //隐藏密码
            case R.id.img_forget_hindpassword:

                break;
            //重置密码 按钮   0 注册  1 找回密码
            case R.id.rbtn_forget_reset_password:
                // 防止多少点击
                if (CommonUtils.isFastDoubleClick()) {
                    return;
                }

                String phone = edtForgetPhone.getText().toString().trim();
                String verify = edtForgetVerify.getText().toString().trim();
                String password = edtForgetOutPassword.getText().toString().trim();
                String confim_password = edtForgetConfimPassword.getText().toString().trim();
                if (password.equals(confim_password)) {
                    login_presener.Login_Post_Presener(1, phone, password, verify, mContext);
                } else {
                    Toast.makeText(this, "两次密码不同", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void sccessCallBack(Object o, String str) {
        boolean boo = (boolean) o;
        isboo = boo;
        if (isboo && rbtnForgetGaincode != null) {
            new TimeCount(60000, 1000, rbtnForgetGaincode).start();
        }
    }

    @Override
    public void errCallBack(String err, int code) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (login_presener != null) {
            login_presener.dettachView();
        }
    }
}
