package com.example.kun.mydemo.adapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kun.mydemo.R;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {


    private List<String> listStr; //用于存放添加Fragment的结合
    private List<Fragment> listTv;//用于存放Fragment的集合

    public MyPagerAdapter(FragmentManager fm ,List<String> ls , List<Fragment> lf ) {
        super(fm);
        this.listStr = ls ;
        this.listTv = lf ;
    }

    @Override
    public Fragment getItem(int i) {
        return listTv.get(i);
    }

    @Override
    public int getCount() {
        return listTv.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listStr.get(position);
    }







}
