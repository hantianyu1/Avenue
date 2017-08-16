package hantianyu1504d.bwie.com.avenue.mine.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.base.BaseActvitiy;
import hantianyu1504d.bwie.com.avenue.mine.presener.Phone_Mine_Presener;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IPhone_Mine_View;

/**
 * Created by lichaohui on 2017/8/14.
 */

public class Phone_Mine_Activity extends BaseActvitiy  implements IPhone_Mine_View{
    @BindView(R.id.edt_chang_phone)
    EditText edtChangPhone;
    @BindView(R.id.edt_chang_verification)
    EditText edtChangVerification;
    @BindView(R.id.rbtn_chang_verification)
    RadioButton rbtnChangVerification;
    @BindView(R.id.rbtn_chang_confirm)
    RadioButton rbtnChangConfirm;
    private Phone_Mine_Presener phone_mine_presener;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        phone_mine_presener = new Phone_Mine_Presener();
        phone_mine_presener.attachView(this);
    }

    @Override
    public int initContentView() {
        return R.layout.changephone_mine;
    }

    @OnClick({R.id.rbtn_chang_verification, R.id.rbtn_chang_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 获取验证码
            case R.id.rbtn_chang_verification:
                String phone = edtChangPhone.getText().toString().trim();
                phone_mine_presener.load_Phone_verification(phone, mContext);

                break;
            // 确定
            case R.id.rbtn_chang_confirm:
                String phone1 = edtChangPhone.getText().toString().trim();
                String verification = edtChangVerification.getText().toString().trim();
                phone_mine_presener.load_Phone_Mine(phone1, verification, mContext);

                break;
        }
    }

    @Override
    public void sccessCallBack(Object o, String str) {

    }

    @Override
    public void errCallBack(String err, int code) {

    }
}
