package hantianyu1504d.bwie.com.avenue.rebate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecordActivity extends AppCompatActivity {

    @BindView(R.id.img_return)
    ImageView imgReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.img_return)
    public void onViewClicked() {
        RecordActivity.this.finish();
    }
}