package com.example.kun.mydemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private View mview ;
    private Context mcontext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(getLayoutId(),null);
        ButterKnife.bind(this,mview);
        init();
        return mview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext = getActivity();
    }

    /**
     * 布局的资源id
     *
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化
     *
     */
    protected abstract void init();

    public abstract void refuse();



    public Context getContext(){
        return this.mcontext;
    }

    public View getVier(){
        return this.mview;
    }
}
