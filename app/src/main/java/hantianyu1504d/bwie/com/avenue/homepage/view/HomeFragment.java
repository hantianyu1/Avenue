package hantianyu1504d.bwie.com.avenue.homepage.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hantianyu1504d.bwie.com.avenue.R;
import hantianyu1504d.bwie.com.avenue.homepage.mode.HomeView;
import hantianyu1504d.bwie.com.avenue.homepage.presenter.HomePresenter;


public class HomeFragment extends Fragment implements HomeView{
    private HomePresenter presenter;
    private static final String TAG = "HomeFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new HomePresenter(this);
        presenter.getDate();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void upDate(String s) {
        Log.e(TAG, "onSuessce: "+ s);
    }
}
