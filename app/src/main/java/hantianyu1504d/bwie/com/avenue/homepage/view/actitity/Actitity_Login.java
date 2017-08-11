package hantianyu1504d.bwie.com.avenue.homepage.view.actitity;


import android.os.Handler;
import android.os.Message;
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
import hantianyu1504d.bwie.com.avenue.homepage.presener.Login_Presener;
import hantianyu1504d.bwie.com.avenue.homepage.view.iview.IMainView;

import static hantianyu1504d.bwie.com.avenue.R.id.et_login;


/**
 * Created by lichaohui on 2017/8/10.
 */

public class Actitity_Login extends BaseActvitiy implements IMainView {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(et_login)
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
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (imgStartpage != null) {
                        imgStartpage.setVisibility(View.GONE);
                        rlayoutLogin.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }
    };

    @BindView(R.id.img_startpage)
    ImageView imgStartpage;
    private Login_Presener login_presener;

    @Override
    public void initData() {
        login_presener = new Login_Presener();
        login_presener.attachView(this);
    }

    @Override
    public void initView() {
        if (imgStartpage != null) {
            imgStartpage.setVisibility(View.VISIBLE);
            handler.sendEmptyMessageDelayed(1, 2000);
        }

    }

    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }


    @Override
    public void sccessCallBack(Object o) {

    }

    @Override
    public void errCallBack(String err, int code) {

    }


    @OnClick({R.id.img_back, R.id.action_login_send, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:

                break;
            case R.id.action_login_send:

                login_presener.Login_Post_Presener(etLogin.getText().toString().trim(), mContext);
                break;
            case R.id.btn_login:
                boolean checked = chkLoginSelect.isChecked();
                if (checked) {
                    String password = edtLoginPassword.getText().toString().trim();
                    String code = etLoginVerify.getText().toString().trim();
                    login_presener.Login_Post_Presener(etLogin.getText().toString().trim(), password, code, mContext);
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
