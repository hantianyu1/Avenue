package hantianyu1504d.bwie.com.avenue.mine.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import hantianyu1504d.bwie.com.avenue.R;
/**
 * Created by lichaohui on 2017/8/24.
 */

public class MyFragment_Mine_Adapter extends BaseAdapter {
    String[] list = {"消费记录", "安全设置", "消息", "关于我们"};
    private Context context;
    private ViewHolder viewHolder;

    public MyFragment_Mine_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list != null ? list.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_mine_fragment, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.txt_item_adapter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list[position]);
        return convertView;
    }

    private static class ViewHolder {
        TextView textView;

    }

}
