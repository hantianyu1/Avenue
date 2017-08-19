package hantianyu1504d.bwie.com.avenue.rebate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RebateAlreadyData;

import static hantianyu1504d.bwie.com.avenue.rebate.bean.Url.ALREADYURL;

/**
 * 类的作用:已返利
 * author: 刘婕
 * date:2017/8/14
 */

public class AlreadyFragment extends Fragment implements HttpUtils.RealCall<RebateAlreadyData> {
    @BindView(R.id.txt_already_a)
    TextView txtA;
    @BindView(R.id.txt_already_calander)
    TextView txtCalander;
    @BindView(R.id.txt_already)
    TextView txtAlready;
    @BindView(R.id.txt_already_price)
    TextView txtAlreadyPrice;
    @BindView(R.id.txt_already_money)
    TextView txtAlreadyMoney;
    @BindView(R.id.shidao)
    TextView shidao;
    @BindView(R.id.shidao_price)
    TextView shidaoPrice;
    Unbinder unbinder;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rebate_radio_already, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        token = (String) SPUtil.get(getActivity(), Canstant.anim.TOKEN, "");
        initPriceData();
    }

    private void initPriceData() {
        HttpUtils utils = new HttpUtils(this);
        Map<String, String> map = new HashMap<>();
        map.put("token",token);
        map.put("status", "1");
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        utils.loadDataFromServerPost(ALREADYURL, map, RebateAlreadyData.class);
    }

    @Override
    public void onSuessce(RebateAlreadyData recordData) {
        txtAlreadyPrice.setText(recordData.getCode());
    }

    @Override
    public void onError(String str) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
