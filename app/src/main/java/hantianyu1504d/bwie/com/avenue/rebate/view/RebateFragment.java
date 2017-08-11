package hantianyu1504d.bwie.com.avenue.rebate.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hantianyu1504d.bwie.com.avenue.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RebateFragment extends Fragment {


    private TextView mTxt;

    public RebateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rebate, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SpannableString spannableString = new SpannableString("5月25日（明天）返利230元");
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.6f);
        spannableString.setSpan(sizeSpan01, 11, 14, Spanned.SPAN_INCLUSIVE_INCLUSIVE );
        mTxt.setText(spannableString);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTxt = (TextView) view.findViewById(R.id.txt_230);
    }
}
