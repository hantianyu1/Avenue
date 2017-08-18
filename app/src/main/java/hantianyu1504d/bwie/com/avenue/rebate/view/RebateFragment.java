package hantianyu1504d.bwie.com.avenue.rebate.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.rebate.activity.CalenderActivity;
import hantianyu1504d.bwie.com.avenue.rebate.activity.RebatePlanActivity;
import hantianyu1504d.bwie.com.avenue.rebate.activity.RecordActivity;
import hantianyu1504d.bwie.com.avenue.rebate.adapter.RecyclerViewAdapter;
import hantianyu1504d.bwie.com.avenue.rebate.bean.CountCashbackData;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RebatePlanData;
import hantianyu1504d.bwie.com.avenue.rebate.present.CountCashPresenter;
import hantianyu1504d.bwie.com.avenue.rebate.present.ICountCashView;
import hantianyu1504d.bwie.com.avenue.rebate.present.IPlanView;
import hantianyu1504d.bwie.com.avenue.rebate.present.PlanPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class RebateFragment<T> extends Fragment implements ICountCashView<T>, IPlanView<T> {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.txt_230)
    TextView mTxt;
    Unbinder unbinder;
    @BindView(R.id.calender)
    ImageView calender;
    @BindView(R.id.txt_first)
    TextView txtFirst;
    @BindView(R.id.price)
    TextView txtPrice;
    @BindView(R.id.txt_count)
    TextView txtCount;
    @BindView(R.id.txt_record)
    TextView txtRecord;
    @BindView(R.id.btn_more)
    Button btnMore;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RebatePlanData> list = new ArrayList<>();
    private String baseUrl = "http://123.57.33.185:8088/cashback/countCashback";
    private String PlanUrl = "http://123.57.33.185:8088/user/cashback/plan";
    private HttpUtils okhttp;
    private HashMap<String, String> map = new HashMap<>();
    private HashMap<String, String> mapPlan = new HashMap<>();
    private String token;

    public RebateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rebate, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        token = (String) SPUtil.get(getActivity(), Canstant.anim.TOKEN, "");
        CountCashPresenter countPresent = new CountCashPresenter(this);
        map.put("status", "1");
        map.put("token", token);
        countPresent.getCount(baseUrl, map, CountCashbackData.class);

        PlanPresenter planPresenter = new PlanPresenter(this);
        mapPlan.put("token", token);
        planPresenter.getPlan(PlanUrl, mapPlan, RebatePlanData.class);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        SpannableString spannableString = new SpannableString("5月25日（明天）返利230元");
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.6f);
        spannableString.setSpan(sizeSpan01, 11, 14, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTxt.setText(spannableString);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_more, R.id.calender, R.id.txt_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_more:
                if (recyclerViewAdapter.getItemCount() > 2) {
                    btnMore.setClickable(true);
                    btnMore.setText("显示更多");
                    recyclerViewAdapter.AddItem(2);
                    recyclerViewAdapter.notifyDataSetChanged();
                } else {
                    btnMore.setClickable(false);
                    Toast.makeText(getContext(), "无数据", Toast.LENGTH_SHORT).show();
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.calender:
                Intent intent = new Intent(getActivity(), CalenderActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_record:
                Intent record = new Intent(getActivity(), RecordActivity.class);
                startActivity(record);
                break;
        }
    }


    @Override
    public void onSuccessCount(T t) {
        CountCashbackData data = (CountCashbackData) t;
        double waitCashback = data.getObject().getWaitCashback();
        txtPrice.setText(waitCashback + "");
        txtCount.setText(data.getObject().getCountReally() + "");
    }

    @Override
    public void error(String s) {
        Toast.makeText(getContext(), "数据有误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(T t) {
        Log.i("=====", "onSuccess: ");
        final RebatePlanData plan = (RebatePlanData) t;
        list.add(plan);
        list.add(plan);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), list);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent = new Intent(getContext(), RebatePlanActivity.class);
                intent.putExtra("recordCoding", plan.getObject().get(postion).getRecordCoding());
                intent.putExtra("cashbackSpecificDate", plan.getObject().get(postion).getCashbackSpecificDate());
                intent.putExtra("IntegralStyle", plan.getObject().get(postion).getIntegralStyle());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
