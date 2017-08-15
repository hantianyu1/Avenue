package hantianyu1504d.bwie.com.avenue.homepage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.homepage.mode.CategoriesBean;
import hantianyu1504d.bwie.com.avenue.homepage.mode.HomeView;
import hantianyu1504d.bwie.com.avenue.homepage.presenter.MiddlePagerPresenter;
import hantianyu1504d.bwie.com.avenue.homepage.view.Listener.RecyclerListener;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/12 10:33
 */
public class MiddlePagerFragment extends Fragment implements HomeView{
    @BindView(R.id.minddle_grid)
    RecyclerView minddleGrid;
    Unbinder unbinder;
    private List<CategoriesBean.ObjectBean.ListBean> list;
    private Adapter adapter;
    private static final String KEY="key";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_middle, null);
        unbinder = ButterKnife.bind(this, view);


        list=new ArrayList<>();
        MiddlePagerPresenter pagerPresenter=new MiddlePagerPresenter(this);
        String pageNum = getPageNum();
        pagerPresenter.upMiddleDate(pageNum);
        adapter = new Adapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        minddleGrid.setLayoutManager(gridLayoutManager);
        minddleGrid.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void upDate(Object bean) {
        CategoriesBean bean1= (CategoriesBean) bean;
        List<CategoriesBean.ObjectBean.ListBean> beanList = bean1.getObject().getList();
        list.addAll(beanList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void upAddressDate(Object bean) {

    }

    class Adapter extends RecyclerView.Adapter<ViewHolder>implements View.OnClickListener{
        private RecyclerListener listener;

        public void setListener(RecyclerListener listener) {
            this.listener = listener;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=View.inflate(getActivity(),R.layout.main_grid_item,null);
            view.setOnClickListener(this);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.itemView.setTag(position);
            holder.text.setText(list.get(position).getCategoryName());
            Glide.with(getActivity()).load(list.get(position).getPicture()).into(holder.image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public void onClick(View view) {
            if(listener!=null){
                listener.itemListener(view, (Integer) view.getTag());
            }
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            text= (TextView) itemView.findViewById(R.id.main_grid_item_text);
            image= (ImageView) itemView.findViewById(R.id.main_grid_item_image);
        }
    }
        public static Fragment setPageNum(String str){
            MiddlePagerFragment  fragment=new MiddlePagerFragment();
            Bundle bundle=new Bundle();
            bundle.putString(KEY,str);
            fragment.setArguments(bundle);
            return fragment;
        }
    public  String getPageNum(){
        Bundle bundle = getArguments();
        String key = (String) bundle.get(KEY);
        return key;
    }
}
