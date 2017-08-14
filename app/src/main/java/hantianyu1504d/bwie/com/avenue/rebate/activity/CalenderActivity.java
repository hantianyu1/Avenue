package hantianyu1504d.bwie.com.avenue.rebate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.othershe.calendarview.CalendarView;
import com.othershe.calendarview.DateBean;
import com.othershe.calendarview.listener.OnMonthItemChooseListener;
import com.othershe.calendarview.listener.OnMonthItemClickListener;
import com.othershe.calendarview.listener.OnPagerChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hantianyu1504d.bwie.com.avenue.R;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class CalenderActivity extends AppCompatActivity {
    @BindView(R.id.img_return)
    ImageView imgReturn;
    @BindView(R.id.txt_calender)
    TextView txtCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebate);
        ButterKnife.bind(this);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar);
//日历init
        calendarView.init();
        DateBean d = calendarView.getDateInit();
//自定义日期ietm的布局样式
//        calendarView.setOnCalendarViewAdapter(R.layout.activity_rebate_item, new CalendarViewAdapter() {
//            @Override
//            public TextView[] convertView(View view, DateBean date) {
//                TextView solarDay = (TextView) view.findViewById(R.id.solar_day);
//                TextView lunarDay = (TextView) view.findViewById(R.id.lunar_day);
//                return new TextView[]{solarDay, lunarDay};
//            }
//        });
        txtCalender.setText(d.getSolar()[0] + "年" + d.getSolar()[1] + "月" + d.getSolar()[2] + "日");
//月份切换回调
        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                txtCalender.setText(date[0] + "年" + date[1] + "月" + date[2] + "日");

            }
        });

//日期点击回调
        calendarView.setOnItemClickListener(new OnMonthItemClickListener() {
            @Override
            public void onMonthItemClick(View view, DateBean date) {
                Toast.makeText(CalenderActivity.this, "onMonthItemClick:" + date.toString(), Toast.LENGTH_SHORT).show();
                txtCalender.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月" + date.getSolar()[2] + "日");
            }
        });

//日期多选回调
        calendarView.setOnMonthItemChooseListener(new OnMonthItemChooseListener() {
            @Override
            public void onMonthItemChoose(View view, DateBean date, boolean flag) {
                //flag=true代表选中数据，flag=false代表取消选中
            }
        });
    }

    @OnClick(R.id.img_return)
    public void onViewClicked() {
        CalenderActivity.this.finish();
    }
}
