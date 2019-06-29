package com.example.kun.mydemo.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.azhon.suspensionfab.FabAttributes;
import com.azhon.suspensionfab.OnFabClickListener;
import com.azhon.suspensionfab.SuspensionFab;
import com.example.kun.mydemo.MainActivity;
import com.example.kun.mydemo.R;
import com.example.kun.mydemo.adapter.MyPagerAdapter;
import com.example.kun.mydemo.base.BaseActivity;
import com.example.kun.mydemo.base.BaseFragment;
import com.example.kun.mydemo.fragment.BaoxiujiluFragment;
import com.example.kun.mydemo.model.BarCodeBean;
import com.example.kun.mydemo.utils.SpMap;
import com.github.shenyuanqing.zxingsimplify.zxing.Activity.CaptureActivity;
import com.google.gson.Gson;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.dialog.materialdialog.DialogAction;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class UserManActivity extends BaseActivity implements TabLayout.OnTabSelectedListener ,
        OnFabClickListener, View.OnClickListener {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.drawlayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView ;
    @BindView(R.id.title_bar) TitleBar titleBar;


    // 创建Fragment对象
    private BaoxiujiluFragment tabFragment1;
    private BaoxiujiluFragment tabFragment2;
    private Fragment tabFragment3;
    private List<String> ls;
    private List<Fragment> lf ;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_man;
    }

    @Override
    protected void init() {
        initViews();
        intFab();
    }

    private void intFab() {
        //fab onclick
        SuspensionFab fabTop = (SuspensionFab) findViewById(R.id.fab_top);
//构建展开按钮属性
        FabAttributes collection = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#2096F3"))
                .setSrc(getResources().getDrawable(R.drawable.refuse))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(1)
                .build();
        FabAttributes email = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#FF9800"))
                .setSrc(getResources().getDrawable(R.drawable.mail))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(2)
                .build();
        FabAttributes news = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#03A9F4"))
                .setSrc(getResources().getDrawable(R.drawable.news))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(3)
                .build();
        //添加菜单
        fabTop.addFab(collection, email, news);
        //设置菜单点击事件
        fabTop.setFabClickListener(this);

    }

    protected void initViews() {

        ls = new ArrayList<>();
        lf = new ArrayList<>();
        ls.add("报修记录");ls.add("报修历史");
        tabFragment1 = new BaoxiujiluFragment() ;
        tabFragment1.setType(0);
        tabFragment2 = new BaoxiujiluFragment() ;
        tabFragment2.setType(1);
        lf.add(tabFragment1);lf.add(tabFragment2);
        //bottom tab
//        for (String page : ls) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(page));
//        }
        mTabLayout.setTabMode(0);
        mTabLayout.addOnTabSelectedListener(this);
        //拿到适配器
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),ls,lf);
        mViewPager.setAdapter(adapter);
        //ViewpAge的预加载解决方法
        mViewPager.setOffscreenPageLimit(lf.size());

        //TabLayout和ViewPage进行联动
        mTabLayout.setupWithViewPager(mViewPager);
//
//        mViewPager.setAdapter(mPagerAdapter);
//        mTabLayout.setupWithViewPager(mViewPager);

        //菜单按钮
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //左拉菜单点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Menu_exit:
                        showDialog();
                    break;
                    case R.id.Menu_about:
                        Show("about");
                    break;
                    case R.id.Menu_help:
                        Show("help");
                    break;
                }
                return false;
            }
        });



    }




    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }




    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void Show(String msg){
        Toast.makeText(UserManActivity.this,""+msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFabClick(FloatingActionButton fab, Object tag) {
        switch ((int)tag){
            case 1:
                ((BaseFragment)lf.get(mViewPager.getCurrentItem())).refuse();
                Show("刷新");
                break;
            case 2:
                startActivity(new Intent(UserManActivity.this,NewRepairActivity.class));
                //Show("2");
                break;
            case 3:
                getRuntimeRight();
                Show("3");
                break;
        }
    }

    private static final int REQUEST_SCAN = 0;
    /**
     * 获得运行时权限
     */
    private void getRuntimeRight() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UserManActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
        } else {
            jumpScanPage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    jumpScanPage();
                } else {
                    Toast.makeText(getContext(), "拒绝", Toast.LENGTH_LONG).show();
                }
            default:
                break;
        }
    }

    /**
     * 跳转到扫码页
     */
    private void jumpScanPage() {
        startActivityForResult(new Intent(UserManActivity.this, CaptureActivity.class), REQUEST_SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SCAN && resultCode == RESULT_OK) {
            Toast.makeText(UserManActivity.this, data.getStringExtra("barCode"), Toast.LENGTH_LONG).show();
            final String barCode = data.getStringExtra("barCode");
            if(barCode.contains("area") && barCode.contains("address")){
                Gson gs = new Gson();
                try {
                    BarCodeBean bc = gs.fromJson(barCode,BarCodeBean.class);
                    Intent in = new Intent(UserManActivity.this, NewRepairActivity.class);
                    in.putExtra("xcode",true);
                    in.putExtra("code",bc.getArea());
                    in.putExtra("address",bc.getAddress());
                    startActivity(in);
                }catch (Exception e){
                    Show("错误！");
                }

            }else{
                Show("错误！");
            }
        }
    }




    //确认退出？？？
    private void showDialog(){
        new MaterialDialog.Builder(getContext())
                .content("确认退出？")
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        exit();
                    }
                })
                .show();

    }

    @Override
    public void onClick(View v) {

    }

    //退出登陆
    private void exit(){
        startActivity(new Intent(UserManActivity.this, MainActivity.class));
        finish();
        //清空token
        SpMap.clear();
    }
}
