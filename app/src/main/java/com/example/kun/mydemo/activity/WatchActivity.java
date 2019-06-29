package com.example.kun.mydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kun.mydemo.MyApp;
import com.example.kun.mydemo.R;
import com.example.kun.mydemo.adapter.Baoxiu;
import com.example.kun.mydemo.base.BaseActivity;
import com.example.kun.mydemo.model.ResultContent;
import com.example.kun.mydemo.model.req.DataReqBean;
import com.example.kun.mydemo.model.req.UpdateBean;
import com.example.kun.mydemo.netsubscribe.LoginSubscribe;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultListener;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultSub;
import com.example.kun.mydemo.netutils.datalist.OnSuccessDataList;
import com.example.kun.mydemo.netutils.datalist.OnSuccessDataListListener;
import com.example.kun.mydemo.utils.SpMap;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.ClearEditText;
import com.xuexiang.xui.widget.edittext.MultiLineEditText;
import com.xuexiang.xui.widget.spinner.materialspinner.MaterialSpinner;

import butterknife.BindView;

public class WatchActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_watch;
    }
    @BindView(R.id.c_content)
    MultiLineEditText c_content ;
    @BindView(R.id.c_area)
    MaterialSpinner c_area ;
    @BindView(R.id.c_address)
    ClearEditText c_address ;
    @BindView(R.id.c_tel)
    ClearEditText c_tel ;
    @BindView(R.id.c_sub)
    ButtonView c_sub ;
    @BindView(R.id.c_addimg)
    ButtonView c_addimg ;

    private int id = 0;
    private int type = 0;

    @Override
    protected void init() {
        Intent in = getIntent();
        type = in.getIntExtra("type",0);
        Baoxiu baoxiu = (Baoxiu) in.getSerializableExtra("info");
        c_content.setContentText(baoxiu.getContent());
        c_address.setText(baoxiu.getAddress());
        c_tel.setText(baoxiu.getTel());
        int index = baoxiu.getArea();
        id = baoxiu.getId();
        if(index < 19){
            index -= 10 ;
        }else {
            switch (index)
            {
                case 20 :
                    index = 9 ;
                    break ;
                case 30 :
                    index = 10 ;
                    break ;
                case 40 :
                    index = 11 ;
                    break ;
            }
        }
        c_area.setSelectedIndex(index);
        c_sub.setOnClickListener(this);
        c_addimg.setOnClickListener(this);
        if(type == 1){
            c_sub.setVisibility(View.GONE);
            c_area.setEnabled(false );
            c_address.setEnabled(false );
            c_content.setEnabled(false );
            c_tel.setEnabled(false );
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c_sub:
                change();
                break ;
            case R.id.c_addimg:
                startActivity(new Intent(WatchActivity.this,UploadImgActivity.class));
                break;
        }
    }

    private void change() {

        String content = c_content.getContentText().toString();
        String address = c_address.getText().toString();
        String tel = c_tel.getText().toString();
        int area = c_area.getSelectedIndex();
        switch (area){
            case 9:
                area = 20 ;
                break ;
            case 10:
                area = 30 ;
                break ;
            case 11:
                area = 40 ;
                break ;
                default:
                    area += 10 ;
                    break ;
        }
        getDataList(new UpdateBean(content,address,id,area+"",tel));
    }

    private void getDataList( UpdateBean  ub ) {

        LoginSubscribe.updateData(ub,new OnSuccessAndFaultSub(new OnSuccessAndFaultListener() {


            @Override
            public void onSuccess(String result) {
                showToast("请求成功！");
                finish();
            }

            @Override
            public void onFault(String errorMsg) {
                //失败
                showToast("请求失败："+errorMsg);
            }
        },getContext()));
    }

    private void showToast(String msg){
        Toast.makeText(MyApp.getConText(),msg,Toast.LENGTH_SHORT).show();
    }

}
