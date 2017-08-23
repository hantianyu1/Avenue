package hantianyu1504d.bwie.com.avenue.rebate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RecordData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class RecordListViewAdapter extends BaseAdapter {
    private Context context;
    private List<RecordData> list;

    public RecordListViewAdapter(Context context, List<RecordData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.rebate_radio_record_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.money = (TextView) convertView.findViewById(R.id.txt_money);
            holder.direction = (TextView) convertView.findViewById(R.id.direction);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.integralStyle = (ImageView) convertView.findViewById(R.id.integralStyle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RecordData data = list.get(position);
        holder.money.setText(data.getCode());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(data.getObject().getPageNum());
        String format = sdf.format(date);
        holder.time.setText("今天:"+format);
//        holder.name.setText(data.getObject().getList().get(position).getName());
//        holder.money.setText(data.getObject().getList().get(position).getMoney());
//        holder.direction.setText(data.getObject().getList().get(position).getDirection());
//        Glide.with(context).load("").into(holder.integralStyle);
        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView money;
        TextView direction;
        TextView time;
        ImageView integralStyle;
    }
}
