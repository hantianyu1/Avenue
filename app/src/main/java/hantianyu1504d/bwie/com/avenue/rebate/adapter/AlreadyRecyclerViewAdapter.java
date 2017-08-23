package hantianyu1504d.bwie.com.avenue.rebate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RebateAlreadyData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/23
 */

public class AlreadyRecyclerViewAdapter extends RecyclerView.Adapter<AlreadyRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<RebateAlreadyData> list;
    private ViewHolder holder;

    public AlreadyRecyclerViewAdapter(Context context, List<RebateAlreadyData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rebate_already_item, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RebateAlreadyData data = list.get(position);
        holder.txtAlready.setText(data.getCode());
        holder.txtAlreadyPrice.setText(data.getCode());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(data.getObject().getPageNum());
        String format = sdf.format(date);
        holder.txtAlreadyCalander.setText(format);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAlready;
        TextView txtAlreadyCalander;
        TextView txtAlreadyPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            txtAlready = (TextView) itemView.findViewById(R.id.txt_already_a);
            txtAlreadyCalander = (TextView) itemView.findViewById(R.id.txt_already_calander);
            txtAlreadyPrice = (TextView) itemView.findViewById(R.id.txt_already_price);
        }
    }
}
