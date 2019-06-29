package com.example.kun.mydemo.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kun.mydemo.R;
import com.example.kun.mydemo.base.BaseActivity;
import com.example.kun.mydemo.utils.SpMap;
import com.xuexiang.xui.widget.button.ButtonView;

import java.util.Set;

import butterknife.BindView;

public class SetActitivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_actitivity;
    }

    @BindView(R.id.s_ip)
    EditText s_ip;
    @BindView(R.id.s_tel)
    EditText s_tel;
    @BindView(R.id.s_sub)
    ButtonView s_sbu ;

    @Override
    protected void init() {
        s_ip.setText(SpMap.gEt("sip"));
        s_tel.setText(SpMap.gEt("stel"));
        s_sbu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SpMap.sEt("sip",s_ip.getText().toString());
        SpMap.sEt("stel",s_tel.getText().toString());
        Toast.makeText(SetActitivity.this,"设置成功！",Toast.LENGTH_SHORT).show();
        finish();
    }
}
