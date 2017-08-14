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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.activity.CalenderActivity;
import hantianyu1504d.bwie.com.avenue.rebate.activity.RebatePlanActivity;
import hantianyu1504d.bwie.com.avenue.rebate.activity.RecordActivity;
import hantianyu1504d.bwie.com.avenue.rebate.adapter.RecyclerViewAdapter;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RecyclerData;

import static hantianyu1504d.bwie.com.avenue.R.id.btn_more;


/**
 * A simple {@link Fragment} subclass.
 */
public class RebateFragment extends Fragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(btn_more)
    Button btnMore;
    @BindView(R.id.txt_230)
    TextView mTxt;
    Unbinder unbinder;
    @BindView(R.id.calender)
    ImageView calender;
    @BindView(R.id.txt_first)
    TextView txtFirst;
    @BindView(R.id.txt_record)
    TextView txtRecord;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerData> list = new ArrayList<>();

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
        list = RecyclerData.initData();
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), list);

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent=new Intent(getContext(), RebatePlanActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
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

    @OnClick({btn_more, R.id.calender,R.id.txt_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_more:
                if (recyclerViewAdapter.getItemCount() == 2) {
                    recyclerViewAdapter.AddItem(list.size());
                    btnMore.setText("收起更多");
                    recyclerViewAdapter.notifyDataSetChanged();
                } else {
                    btnMore.setText("显示更多");
                    recyclerViewAdapter.AddItem(2);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.calender:
                Intent intent=new Intent(getActivity(), CalenderActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_record:
                Intent record=new Intent(getActivity(), RecordActivity.class);
                startActivity(record);
                break;
        }
    }
}
