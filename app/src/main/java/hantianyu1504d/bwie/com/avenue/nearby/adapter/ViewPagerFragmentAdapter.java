package hantianyu1504d.bwie.com.avenue.nearby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.nearby.bean.SBean;

/**
 * 作者：李飞宇
 * 时间：2017/8/15 21:14
 * 功能：
 */

public class ViewPagerFragmentAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SBean.DataBean> slist;
    private ViewHolder viewHolder;
    private View view;


    public ViewPagerFragmentAdapter(Context context, List<SBean.DataBean> slist) {
        this.context = context;
        this.slist = slist;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.nearby_shop, null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder = (ViewHolder) holder;
        Glide.with(context)
                .load(slist.get(position).getUserImg())
                .into(viewHolder.image_shop_image);
//        Glide.with(context)
//                .load(slist.get(position).getPicture())
//                .into(viewHolder.image_shop_image);
//        viewHolder.text_shop_name.setText(slist.get(position).getShopName());
////        viewHolder.text_shop_price.setText(slist.get(position).getPerCapitaConsumption());
//        int integralRate = slist.get(position).getIntegralRate();
//        viewHolder.text_shop_integral.setText(integralRate+"");
//        viewHolder.text_shop_site.setText(slist.get(position).getDistance());

    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_shop_image;
        TextView text_shop_name;
        TextView text_shop_price;
        TextView text_shop_integral;
        TextView text_shop_site;

        public ViewHolder(View itemView) {
            super(itemView);
            image_shop_image = (ImageView) itemView.findViewById(R.id.recyclerview_shop_image);
            text_shop_name = (TextView) itemView.findViewById(R.id.recyclerview_shop_name);
            text_shop_price = (TextView) itemView.findViewById(R.id.recyclerview_shop_price);
            text_shop_integral = (TextView) itemView.findViewById(R.id.recyclerview_shop_integral);
            text_shop_site = (TextView) itemView.findViewById(R.id.recyclerview_shop_site);
        }
    }
}
