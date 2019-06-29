package com.example.kun.mydemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract  class  BaseActivity extends AppCompatActivity {
    private Context mcontext;

    public Context getContext(){
        return this.mcontext;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        this.mcontext = this ;
        init();
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

}
