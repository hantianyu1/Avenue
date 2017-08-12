package hantianyu1504d.bwie.com.avenue.rebate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RecyclerData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<RecyclerData> list;
    private ViewHolder holder;
    private int num = 2;

    public RecyclerViewAdapter(Context context, List<RecyclerData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_rebate_item, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerData data = list.get(position);
        holder.txtA.setText(data.getName());
        holder.txtCalander.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        if (list.size()>2) {
            return num;
        }else{
            return list.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtA;
        private TextView txtCalander;

        public ViewHolder(View itemView) {
            super(itemView);
            txtA = (TextView) itemView.findViewById(R.id.txt_a);
            txtCalander = (TextView) itemView.findViewById(R.id.txt_calander);
        }
    }
    public void AddItem(int count){
       num= count;
    }
}
