package hantianyu1504d.bwie.com.avenue.mine.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.base.BaseFragment;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.UserLogin;
import hantianyu1504d.bwie.com.avenue.mine.view.activity.Actitity_Log;
import hantianyu1504d.bwie.com.avenue.mine.view.activity.Activity_safety;
import hantianyu1504d.bwie.com.avenue.mine.view.activity.Record_Activity;

import static hantianyu1504d.bwie.com.avenue.R.id.txt_mine_login;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @BindView(R.id.txt_mine_login)
    TextView txtMineLogin;
    @BindView(R.id.txt_mine_record)
    TextView txtMineRecord;
    @BindView(R.id.txt_mine_set)
    TextView txtMineSet;
    @BindView(R.id.txt_mine_news)
    TextView txtMineNews;
    @BindView(R.id.text_mine_about_us)
    TextView textMineAboutUs;
    @BindView(R.id.llayout)
    LinearLayout lLinearLayout;
    @BindView(R.id.txt_mine_username)
    TextView txtMineUsername;
    @BindView(R.id.txt_mine_phone)
    TextView txtMinePhone;
    @BindView(R.id.rbtn_mine_gathering)
    RadioButton rbtnMineGathering;
    @BindView(R.id.rbtn_mine_balance)
    RadioButton rbtnMineBalance;
    @BindView(R.id.rbtn_mine_card)
    RadioButton rbtnMineCard;


    @Override
    public void onResume() {
        super.onResume();
        Log.d("zzz", "Resume");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /*
            * 获取登录信息 ，设置 他们的
            * */
    @Override
    public void onStart() {
        super.onStart();
        Log.d("zzz", "onStart");

        String boo = (String) SPUtil.get(mContext, Canstant.anim.MINE_KEY, "");
        Log.d("zzz", boo+"sdfasdfasdfasdfa");
        if (boo != null && boo != "" && boo.length() > 0) {
            Gson gson = new Gson();
            UserLogin userLog = gson.fromJson(boo, UserLogin.class);
            String phone = userLog.object.phone;
            String nickname = userLog.object.nickname;
            if (txtMineLogin != null && lLinearLayout != null) {
                txtMineLogin.setVisibility(View.GONE);
                lLinearLayout.setVisibility(View.VISIBLE);
                txtMineUsername.setText(nickname);
                txtMinePhone.setText(phone);
            }
        }else {
            txtMineLogin.setVisibility(View.VISIBLE);
            lLinearLayout.setVisibility(View.GONE);

        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }


    @OnClick({txt_mine_login, R.id.txt_mine_record,
            R.id.txt_mine_set, R.id.txt_mine_news, R.id.text_mine_about_us,
            R.id.rbtn_mine_gathering, R.id.rbtn_mine_balance, R.id.rbtn_mine_card, R.id.llayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 注册界面
            case R.id.txt_mine_login:
                startActivity(new Intent(mContext, Actitity_Log.class));
                break;
            // 消费记录
            case R.id.txt_mine_record:
                startActivity(new Intent(mContext, Record_Activity.class));

                break;
            // 安全设置
            case R.id.txt_mine_set:
                startActivity(new Intent(mContext, Activity_safety.class));

                break;
            // 消息
            case R.id.txt_mine_news:
                break;
            // 我们
            case R.id.text_mine_about_us:

                break;
            // 二维码
            case R.id.rbtn_mine_gathering:

                break;
            // 余额
            case R.id.rbtn_mine_balance:
                break;
            // 卡包
            case R.id.rbtn_mine_card:
                startActivity(new Intent(mContext, Record_Activity.class));
                break;
            // 隐藏的账号密码
            case R.id.llayout:
                startActivity(new Intent(mContext, Actitity_Log.class));
                break;


        }
    }
}
