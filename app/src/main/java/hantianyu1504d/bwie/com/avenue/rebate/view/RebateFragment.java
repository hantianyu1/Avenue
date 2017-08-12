package hantianyu1504d.bwie.com.avenue.rebate.view;


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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
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
    Unbinder unbinder;
    private RecyclerViewAdapter adapter;
    private List<RecyclerData> list = new ArrayList<>();
    private TextView mTxt;
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
        adapter = new RecyclerViewAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
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

    @OnClick(btn_more)
    public void onViewClicked() {
        if (adapter.getItemCount() == 2) {
            adapter.AddItem(list.size());
            btnMore.setText("显示更多");
            adapter.notifyDataSetChanged();
        } else {
            btnMore.setText("收起更多");
            adapter.AddItem(2);
            adapter.notifyDataSetChanged();
        }
    }
    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTxt = (TextView) view.findViewById(R.id.txt_230);

    }
}
