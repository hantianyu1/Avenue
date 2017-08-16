package hantianyu1504d.bwie.com.avenue.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/15 15:50
 */
public class NearShopsAdapter extends RecyclerView.Adapter<NearShopsAdapter.ViewHolder>{
private Context context;
    private List<String> list;

    public NearShopsAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.nearbyshops_recycler_item,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.image);
    }

    @Override
    public int getItemCount() {
//        Log.e(TAG, "getItemCount: "+list.get(0) );
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,address;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.nearbyshops_recycler_name);
            address= (TextView) itemView.findViewById(R.id.nearbyshops_recycler_address);
            image= (ImageView) itemView.findViewById(R.id.nearbyshops_recycler_image);
        }
    }
}
