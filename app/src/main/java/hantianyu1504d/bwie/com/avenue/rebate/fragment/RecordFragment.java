package hantianyu1504d.bwie.com.avenue.rebate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.core.utils.HttpUtils;
import hantianyu1504d.bwie.com.avenue.rebate.adapter.RecordListViewAdapter;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RecordData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class RecordFragment extends Fragment implements HttpUtils.RealCall<RecordData> {
    @BindView(R.id.listView)
    ListView listView;
    List<RecordData> list = new ArrayList<>();
    Unbinder unbinder;
    private String baseurl = "http://123.57.33.185:8088/user/intergral/records";
    private static final String TAG = "RecordFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rebate_radio_record, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecordData();
    }

    private void initRecordData() {
        HttpUtils utils = new HttpUtils(this);
        Map<String, String> map = new HashMap<>();
        map.put("token", "faf9105720d000f7bcea972fabb4b518");
        map.put("page.perPageSize", "1");
        map.put("page.currentPageNum", "5");
        utils.loadDataFromServerPost(baseurl, map, RecordData.class);
    }

    @Override
    public void onSuessce(RecordData tClass) {
        RecordData recordData=tClass;
        list.add(recordData);
        RecordListViewAdapter recordListview = new RecordListViewAdapter(getActivity(), list);
        listView.setAdapter(recordListview);
    }

    @Override
    public void onError(String str) {
        Toast.makeText(getContext(),"返利记录无，请检查",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
