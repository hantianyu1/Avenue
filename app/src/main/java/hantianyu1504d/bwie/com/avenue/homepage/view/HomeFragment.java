package hantianyu1504d.bwie.com.avenue.homepage.view;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.homepage.mode.HomeView;
import hantianyu1504d.bwie.com.avenue.homepage.mode.PagerAndShopsBean;
import hantianyu1504d.bwie.com.avenue.homepage.presenter.HomePresenter;


public class HomeFragment extends Fragment implements HomeView {
    @BindView(R.id.main_banner)
    Banner mainBanner;
    @BindView(R.id.main_middle_pager)
    ViewPager mainMiddlePager;
    @BindView(R.id.wangpu_iamge)
    ImageView wangpuIamge;
    @BindView(R.id.main_nuanxin_text)
    TextView mainNuanxinText;
    @BindView(R.id.main_dadao_text)
    TextView mainDadaoText;
    @BindView(R.id.right_one_image)
    ImageView rightOneImage;
    @BindView(R.id.right_two_image)
    ImageView rightTwoImage;
    @BindView(R.id.main_search_image)
    ImageView mainSearchImage;
    @BindView(R.id.foot_tab)
    TabLayout footTab;
    @BindView(R.id.foot_viewpaer)
    ViewPager footViewpaer;
    Unbinder unbinder;
    private HomePresenter presenter;
    private static final String TAG = "HomeFragment";
    private List<Fragment> mFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new HomePresenter(this);
        presenter.getDateBanner();


        init();
        mainMiddlePager.setAdapter(new FragAdapter(getFragmentManager()));

        return view;
    }
    public void init(){
        mFragments=new ArrayList<>();
        mFragments.add(MiddlePagerFragment.setPageNum("1"));
        mFragments.add(MiddlePagerFragment.setPageNum("2"));
    }
    @Override
    public void upDate(Object object) {
        PagerAndShopsBean bean= (PagerAndShopsBean) object;
        List<PagerAndShopsBean.ObjectBean.ListBean> list = bean.getObject().getList();
        List<String> imageList=new ArrayList<>();

        for (int i = 0; i <list.size() ; i++) {
            imageList.add(list.get(i).getPicture());
        }

        imageList.clear();
        imageList.add("http://imgsrc.baidu.com/imgad/pic/item/267f9e2f07082838b5168c32b299a9014c08f1f9.jpg");
        imageList.add("http://img2.imgtn.bdimg.com/it/u=1989212580,3203216431&fm=214&gp=0.jpg");
        imageList.add("http://pic96.nipic.com/file/20160429/21289054_220047597697_2.jpg");
        imageList.add("http://img3.duitang.com/uploads/item/201205/07/20120507205511_vNtWf.jpeg");
        imageList.add("http://pic1.16pic.com/00/10/80/16pic_1080912_b.jpg");
        imageList.add("http://pic.35pic.com/normal/08/25/08/7487939_193935318119_2.jpg");
        mainBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        mainBanner.setImages(imageList);
        mainBanner.setDelayTime(2000);
        mainBanner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    class FragAdapter extends FragmentPagerAdapter {


        public FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {

            return mFragments.get(arg0);
        }

        @Override
        public int getCount() {

            return mFragments.size();
        }

    }

}
