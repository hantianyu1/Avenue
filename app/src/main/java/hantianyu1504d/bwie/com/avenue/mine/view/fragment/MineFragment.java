package hantianyu1504d.bwie.com.avenue.mine.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import hantianyu1504d.bwie.com.avenue.mine.view.adapter.MyFragment_Mine_Adapter;
/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.txt_mine_login)
    TextView txtMineLogin;
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
    @BindView(R.id.listview)
    ListView listFragmentMine;

    /*
    * 获取登录信息 ，设置 他们的
    * */
    @Override
    public void onStart() {
        super.onStart();
        String boo = (String) SPUtil.get(mContext, Canstant.anim.MINE_KEY, "");
        if (boo != null && boo != "" && boo.length() > 0) {
            Gson gson = new Gson();
            Log.d("zzz", boo);
            UserLogin userLog = gson.fromJson(boo, UserLogin.class);
            String phone = userLog.object.phone;
            String nickname = userLog.object.nickname;
            String token = userLog.object.token;
            String str = (String) SPUtil.get(mContext, Canstant.anim.TOKEN, "");
            if (str != null && str.length() > 0) {
            } else {
                SPUtil.put(mContext, Canstant.anim.TOKEN, token);
            }
            if (txtMineLogin != null && lLinearLayout != null) {
                txtMineLogin.setVisibility(View.GONE);
                lLinearLayout.setVisibility(View.VISIBLE);
                txtMineUsername.setText(nickname);
                txtMinePhone.setText(phone);
            }
        } else {
            txtMineLogin.setVisibility(View.VISIBLE);
            lLinearLayout.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        MyFragment_Mine_Adapter myFragment_mine_adapter = new MyFragment_Mine_Adapter(mContext);
        listFragmentMine.setAdapter(myFragment_mine_adapter);
        listFragmentMine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: // 消费记录
                        break;
                    case 1:// 安全设置
                        String str = (String) SPUtil.get(mContext, Canstant.anim.TOKEN, "");
                        if (str != null && str.length() > 0) {
                            startActivity(new Intent(mContext, Activity_safety.class));
                        } else {
                            startActivity(new Intent(mContext, Actitity_Log.class));
                        }
                        break;
                    case 2: // 消息
                        break;
                    case 3: // 关于我们
                        break;

                }
            }
        });

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.txt_mine_login, R.id.rbtn_mine_gathering, R.id.rbtn_mine_balance, R.id.rbtn_mine_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_mine_login: // 注册界面
                startActivity(new Intent(mContext, Actitity_Log.class));
                break;
            case R.id.rbtn_mine_gathering:    // 二维码
                break;
            case R.id.rbtn_mine_balance:  // 余额
                break;
            case R.id.rbtn_mine_card:// 卡包
                break;
        }
    }
}
