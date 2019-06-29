package com.example.kun.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kun.mydemo.activity.RepairManActivity;
import com.example.kun.mydemo.activity.SetActitivity;
import com.example.kun.mydemo.activity.UserManActivity;
import com.example.kun.mydemo.model.TokenBean;
import com.example.kun.mydemo.model.UserBean;
import com.example.kun.mydemo.model.UserInfo;
import com.example.kun.mydemo.netsubscribe.LoginSubscribe;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultListener;
import com.example.kun.mydemo.netutils.OnSuccessAndFaultSub;
import com.example.kun.mydemo.netutils.login.OnSuccessLogin;
import com.example.kun.mydemo.netutils.login.OnSuccessLoginListener;
import com.example.kun.mydemo.netutils.uinfo.OnSuccessUinfo;
import com.example.kun.mydemo.netutils.uinfo.OnSuccessUinfoListener;
import com.example.kun.mydemo.utils.GsonUtils;
import com.example.kun.mydemo.utils.SpMap;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.ClearEditText;
import com.xuexiang.xui.widget.edittext.PasswordEditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static  String TAG = "Main";

    @BindView(R.id.login)
    ButtonView login;
    @BindView(R.id.set)
    ButtonView set;
    @BindView(R.id.username)
    ClearEditText username;
    @BindView(R.id.password)
    PasswordEditText password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authState();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void authState() {
        if(!SpMap.getToken().equals("")){
            long time = new Date().getTime();
            if(SpMap.getTimed()>new Date().getTime()){
                //通过  判断身份
                authIntent();
            }else{
                //身份过期 重新登陆
                Toast.makeText(MainActivity.this, "身份过期，重新登陆！" , Toast.LENGTH_SHORT).show();
                SpMap.clear();
            }
        }
    }

    //通过身份来进入不同的activity
    private void authIntent() {
        int role = SpMap.getRole();
        if(role != -1){
            BaseConstant.TOKEN = SpMap.getToken();
            switch (role){
                case 0:
                    startActivity(new Intent(MainActivity.this, UserManActivity.class));
                    finish();
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, RepairManActivity.class));
                    finish();
                    break;
            }
        }else{
            Toast.makeText(MainActivity.this, "身份错误，重新登陆！" , Toast.LENGTH_SHORT).show();
            SpMap.clear();
        }
    }

    private void initView() {
        password.setText(SpMap.gEt("password"));
        username.setText(SpMap.gEt("username"));
        login.setOnClickListener(this);
        set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                login();
                break;
            case R.id.set:
                startActivity(new Intent(MainActivity.this, SetActitivity.class));
                break;
        }
    }

    private void loginTO(String us ,String ps) {
        SpMap.sEt("sno",us);
        LoginSubscribe.loginQueryData(new UserBean(us,ps), new OnSuccessLogin(new OnSuccessLoginListener() {
            @Override
            public void onSuccess(TokenBean result) {
                //成功
                Toast.makeText(MainActivity.this, "请求成功~", Toast.LENGTH_SHORT).show();
                BaseConstant.TOKEN = result.getToken();
                SpMap.setn(new Date().getTime() + 100 * 60 * 60 * 24);
                SpMap.setToken(result.getToken());
                getUserInfo();
            }

            @Override
            public void onFault(String errorMsg) {
                //失败
                Toast.makeText(MainActivity.this, "请求失败：" + errorMsg, Toast.LENGTH_SHORT).show();
            }
        },MainActivity.this));
    }


    private void getUserInfo(){
        LoginSubscribe.getUserInfo(SpMap.gEt("sno"), new OnSuccessUinfo(new OnSuccessUinfoListener() {
            @Override
            public void onSuccess(UserInfo result) {
                //成功
                Toast.makeText(MainActivity.this, "请求成功~", Toast.LENGTH_SHORT).show();
                SpMap.setRole(result.getRole());
                authState();
            }

            @Override
            public void onFault(String errorMsg) {
                //失败
                Toast.makeText(MainActivity.this, "请求失败：" + errorMsg, Toast.LENGTH_SHORT).show();
            }
        },MainActivity.this));
    }


    private void login() {
        String us = username.getEditableText().toString();
        String ps = password.getEditableText().toString();
        if(us.trim().equals("") || ps.trim().equals("")){
            Show("用户名密码不能为空！");
            return ;
        }
        SpMap.sEt("username",us);
        SpMap.sEt("password",ps);
        loginTO(us,ps);
    }

    private void Show(String str){
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.exit(0);
    }

}
