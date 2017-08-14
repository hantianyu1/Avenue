package hantianyu1504d.bwie.com.avenue.mine.view.activity;


import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.base.BaseActvitiy;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.UserLog;
import hantianyu1504d.bwie.com.avenue.mine.presener.Login_Presener;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IMainView;


/**
 * Created by lichaohui on 2017/8/10.
 */

public class Actitity_Log extends BaseActvitiy implements IMainView<UserLog> {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_mine_log)
    TextView txtMineLog;
    @BindView(R.id.edt_log_phone)
    EditText edtLogPhone;
    @BindView(R.id.edt_log_password)
    EditText edtLogPassword;
    @BindView(R.id.rbtn_mine_log)
    RadioButton rbtnMineLog;
    @BindView(R.id.txt_mine_forgetpass)
    TextView txtMineForgetpass;
    private Login_Presener login_presener;

    @Override
    public void sccessCallBack(UserLog userLog,String msg) {
        if (msg!=null && msg!=""){
            SPUtil.put(mContext,Canstant.anim.MINE_KEY,msg);
        }


    }

    @Override
    public void errCallBack(String err, int code) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        login_presener = Login_Presener.getInstanct();
        login_presener.attachView(this);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_mine_log;
    }


    @OnClick({R.id.img_back, R.id.txt_mine_log, R.id.rbtn_mine_log, R.id.txt_mine_forgetpass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回
            case R.id.img_back:
                finish();
                break;
            //跳到注册界面
            case R.id.txt_mine_log:
                startActivity(new Intent(mContext, Actitity_Login.class));
                break;
            // 登录按钮
            case R.id.rbtn_mine_log:
                String password = edtLogPassword.getText().toString().trim();
                String phone = edtLogPhone.getText().toString().trim();
                login_presener.loadPresener(phone, password, mContext);
                break;
            // 忘记密码
            case R.id.txt_mine_forgetpass:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (login_presener != null) {
            login_presener.dettachView();
        }

    }
}
