package com.example.kun.mydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kun.mydemo.MyApp;
import com.example.kun.mydemo.R;
import com.example.kun.mydemo.base.BaseActivity;
import com.example.kun.mydemo.model.req.NewRepairBean;
import com.example.kun.mydemo.model.req.UpdateBean;
import com.example.kun.mydemo.netsubscribe.LoginSubscribe;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultListener;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultSub;
import com.example.kun.mydemo.utils.AreaFactory;
import com.example.kun.mydemo.utils.CodeFactory;
import com.example.kun.mydemo.utils.SpMap;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.ClearEditText;
import com.xuexiang.xui.widget.edittext.MultiLineEditText;
import com.xuexiang.xui.widget.edittext.ValidatorEditText;
import com.xuexiang.xui.widget.spinner.materialspinner.MaterialSpinner;

import butterknife.BindView;

public class NewRepairActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.n_content)
    MultiLineEditText n_content;
    @BindView(R.id.n_other)
    MultiLineEditText n_other;
    @BindView(R.id.n_area)
    MaterialSpinner n_area ;
    @BindView(R.id.n_tel)
    ClearEditText n_tel ;
    @BindView(R.id.n_address)
    ClearEditText n_address ;
    private NewRepairBean nr ;
    @BindView(R.id.n_sub)
    ButtonView n_sub ;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_repair;
    }

    @Override
    protected void init() {
        n_sub.setOnClickListener(this);
        Intent in = getIntent();
        nr = new NewRepairBean();
        if(in.getBooleanExtra("xcode",false)){
            nr.setAddress(in.getStringExtra("address"));
            int area = in.getIntExtra("area",10);
            nr.setArea(area+"");
            n_address.setText(nr.getAddress());
            n_area.setSelectedIndex(AreaFactory.getSpinnerIndex(area));
        }
        n_tel.setText(SpMap.gEt("stel"));

    }

    private void addRepair( NewRepairBean nr ) {

        LoginSubscribe.newRepair(SpMap.gEt("sno"),nr,new OnSuccessAndFaultSub(new OnSuccessAndFaultListener() {


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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.n_sub:
                subNewItem();
                break;
        }
    }

    private void subNewItem() {

        nr.setArea(AreaFactory.getAreaIndex(n_area.getSelectedIndex())+"");
        nr.setAddress(n_address.getText().toString());
        nr.setContent(n_content.getContentText());
        nr.setComments(n_other.getContentText());
        nr.setRepair_status(0);
        nr.setTelephone(n_tel.getText().toString());
        nr.setCode(CodeFactory.getCode(""));
        addRepair(nr);
    }

    private void showToast(String msg){
        Toast.makeText(MyApp.getConText(),msg,Toast.LENGTH_LONG).show();
    }
}
