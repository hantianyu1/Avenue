package hantianyu1504d.bwie.com.avenue.mine.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.base.BaseFragment;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.UserLog;
import hantianyu1504d.bwie.com.avenue.mine.view.activity.Actitity_Log;

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

/*
*
* 获取登录信息 ，设置 他们的
*
* */
    @Override
    public void onResume() {
        super.onResume();
        String boo = (String) SPUtil.get(mContext, Canstant.anim.MINE_KEY,"");
        if (boo != null && boo != "") {
            Gson gson = new Gson();
            UserLog userLog = gson.fromJson(boo, UserLog.class);
            UserLog.ObjectBean object = userLog.object;
            if (txtMineLogin != null && lLinearLayout != null) {
                txtMineLogin.setVisibility(View.GONE);
                lLinearLayout.setVisibility(View.VISIBLE);
                txtMineUsername.setText(object.nickname);
                txtMinePhone.setText(object.phone);
            }

        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }


    @OnClick({txt_mine_login, R.id.txt_mine_record, R.id.txt_mine_set, R.id.txt_mine_news, R.id.text_mine_about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 注册界面
            case txt_mine_login:
                Toast.makeText(mContext, "txt_mine_login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mContext, Actitity_Log.class));

                break;
            // 消费记录
            case R.id.txt_mine_record:
                break;
            // 安全设置
            case R.id.txt_mine_set:
                break;
            // 消息
            case R.id.txt_mine_news:
                break;
            // 我们
            case R.id.text_mine_about_us:
                // 清除 sp 记录
                SPUtil.clear(mContext);
                break;
        }
    }

}
