package hantianyu1504d.bwie.com.avenue.mine.view.activity;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
 * Created by lichaohui on 2017/8/10.
 * 该页面 为注册页面
 *
 */

public class Actitity_Login extends BaseActvitiy implements IMainView {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.et_login_verify)
    EditText etLoginVerify;
    @BindView(R.id.action_login_send)
    Button actionLoginSend;
    @BindView(R.id.llayout)
    LinearLayout llayout;
    @BindView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @BindView(R.id.img_login_eye)
    ImageView imgLoginEye;
    @BindView(R.id.chk_login_select)
    CheckBox chkLoginSelect;
    @BindView(R.id.txt_login_spang)
    TextView txtLoginSpang;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.rlayout_login)
    RelativeLayout rlayoutLogin;
    private Login_Presener login_presener;
    private TimeCount timeCount;

    @Override
    public void initData() {
        login_presener =  new  Login_Presener();
        login_presener.attachView(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }


    @Override
    public void sccessCallBack(Object o,String msg ) {
        boolean boo= (boolean) o;
        if (boo){
            timeCount = new TimeCount(60000, 1000, actionLoginSend);
            timeCount.start();
        }
    }

    @Override
    public void errCallBack(String err, int code) {

    }


    @OnClick({R.id.img_back, R.id.action_login_send, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
            finish();
                break;
            // 发送验证码  注册      * 0 登录  1 注册  2 找回密码
            case R.id.action_login_send:
                // 防止多少点击
                if (CommonUtils.isFastDoubleClick()) {
                    return;
                }
                boolean b = login_presener.Login_Post_Presener(1, etLogin.getText().toString().trim(), mContext, Note.class);
                break;
            // 登录  1验证码 2 手机号，3密码
            case R.id.btn_login:
                if (CommonUtils.isFastDoubleClick()) {
                    return;
                }

                    boolean checked = chkLoginSelect.isChecked();
                if (checked) {
                    String password = edtLoginPassword.getText().toString().trim();
                    String code = etLoginVerify.getText().toString().trim();
                    login_presener.Login_Post_Presener(0,etLogin.getText().toString().trim(), password, code, mContext);
                } else {
                    Toast.makeText(this, "请阅读协议", Toast.LENGTH_SHORT).show();
                }
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
