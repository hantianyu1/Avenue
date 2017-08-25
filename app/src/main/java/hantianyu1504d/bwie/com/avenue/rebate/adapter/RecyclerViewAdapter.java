package hantianyu1504d.bwie.com.avenue.rebate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.rebate.bean.RebatePlanData;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<RebatePlanData> list=new ArrayList<>();
    private ViewHolder holder;
    private int num = 2;
    private MyItemClickListener mListener = null;

    public RecyclerViewAdapter(Context context, List<RebatePlanData> list) {
        this.context = context;
        this.list = list;
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int postion);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_rebate_item, null);
        holder = new ViewHolder(view, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RebatePlanData data = list.get(position);
        holder.txtA.setText(data.getObject().get(position).getRecordCoding());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(data.getObject().get(position).getCashbackSpecificDate());
        String format = sdf.format(date);
        holder.txtCalander.setText(format + "兑换");
        Glide.with(context).load(data.getObject().get(position).getIntegralStyle()).into(holder.imageview);
        holder.itemView.setTag(position);//将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (list.size() > num) {
            return num;
        } else {
            return list.size();
        }
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
//注意这里使用getTag方法获取position
            mListener.onItemClick(v, (int) v.getTag());
        }

    }

    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtA;
        private TextView txtCalander;
        private TextView txt50;
        private ImageView imageview;

        public ViewHolder(View itemView, MyItemClickListener mListener) {
            super(itemView);
            txtA = (TextView) itemView.findViewById(R.id.txt_a);
            txtCalander = (TextView) itemView.findViewById(R.id.txt_calander);
            txt50 = (TextView) itemView.findViewById(R.id.txt_50);
            imageview = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

    public void AddItem(int count) {
        num = count;
    }
}
