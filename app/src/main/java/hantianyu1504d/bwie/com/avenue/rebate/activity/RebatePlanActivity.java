package hantianyu1504d.bwie.com.avenue.rebate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class RebatePlanActivity extends AppCompatActivity {
    @BindView(R.id.img_return)
    ImageView imgReturn;
    @BindView(R.id.get_recordCoding)
    TextView getRecordCoding;
    @BindView(R.id.get_cashbackSpecificDate)
    TextView getCashbackSpecificDate;
    @BindView(R.id.get_IntegralStyle)
    ImageView getIntegralStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebateplan);
        ButterKnife.bind(this);
        //传值
        Intent intent = getIntent();
        String recordCoding = intent.getStringExtra("recordCoding");
        String cashbackSpecificDate = intent.getStringExtra("cashbackSpecificDate");
        String integralStyle = intent.getStringExtra("IntegralStyle");
        getRecordCoding.setText(recordCoding);
        getCashbackSpecificDate.setText(cashbackSpecificDate);
        Glide.with(this).load(integralStyle).into(getIntegralStyle);
    }


    @OnClick(R.id.img_return)
    public void onViewClicked() {
        RebatePlanActivity.this.finish();
    }
}
