package com.example.kun.mydemo.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.kun.mydemo.R;
import com.example.kun.mydemo.activity.WatchActivity;
import com.example.kun.mydemo.adapter.Baoxiu;
import com.example.kun.mydemo.adapter.MyRecyAdapter;
import com.example.kun.mydemo.base.BaseFragment;
import com.example.kun.mydemo.model.ContentBean;
import com.example.kun.mydemo.model.ResultContent;
import com.example.kun.mydemo.model.req.DataReqBean;
import com.example.kun.mydemo.netsubscribe.LoginSubscribe;
import com.example.kun.mydemo.netutils.datalist.OnSuccessDataList;
import com.example.kun.mydemo.netutils.datalist.OnSuccessDataListListener;
import com.example.kun.mydemo.utils.TimeUtil;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class BaoXiuLiShiFragment extends BaseFragment {

    //以下5行为自定义列表
    @BindView(R.id.recyclerview)
    XRecyclerView mRecyclerView;
    private MyRecyAdapter mAdapter;
    private ArrayList<String> listData;
    private int type = 0;
    private ArrayList<Baoxiu> arrayBx = new ArrayList<>();
    private int currentIndex = 0 , allIndex = 0 ;

    public void setType(int type) {
        this.type = type;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_baoxiushenpi;
    }

    @Override
    protected void init() {
        initRecyView();
    }


    private void initRecyView() {
        try {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);

            mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
            mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);


            mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            arrayBx.clear();
                            refuse();
                        }

                    }, 1000);            //refresh data here
                }

                @Override
                public void onLoadMore() {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if(currentIndex < allIndex - 1){
                                currentIndex ++ ;
                                getDataList(currentIndex);
                                mRecyclerView.loadMoreComplete();
                                mAdapter.notifyDataSetChanged();
                            }else{
                                mRecyclerView.setNoMore(true);
                                mAdapter.notifyDataSetChanged();
                                showToast("已经到末页！");
                            }
                        }
                    }, 1000);

                }
            });
            mAdapter = new MyRecyAdapter(arrayBx,1);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setClickCallBack(new MyRecyAdapter.ItemClickCallBack() {
                @Override
                public void onItemClick(int pos) {
                    Baoxiu baoxiuInfo = mAdapter.getItem(pos);
                    Intent in = new Intent(getContext(), WatchActivity.class);
                    in.putExtra("info",baoxiuInfo);
                    in.putExtra("type",type);
                    startActivity(in);
                }
            });
            mRecyclerView.refresh();
        }catch (Exception e){
            Log.i("KK",e.toString());
        }

    }

    private void turn2(ContentBean cb){
        for (ContentBean.DataBean bean : cb.getContent()) {

            try {
                arrayBx.add(new Baoxiu(bean.getContent(),bean.getAddress(),bean.getIsEvaluate(),
                        TimeUtil.longToString(bean.getCreate_time(),"yyyy-MM-dd HH:mm:ss"),
                        bean.getTelephone(),bean.getArea(),bean.getId()));
            }catch (Exception e){

            }
        }

    }

    private void refuse(ContentBean cb){
        turn2(cb);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.refreshComplete();
    }



    private void getDataList( int page ) {
        DataReqBean dq = new DataReqBean("","","","",10,page, "","3");
        LoginSubscribe.getDataList(page,dq, new OnSuccessDataList(new OnSuccessDataListListener() {
            @Override
            public void onSuccess(ResultContent result) {
                //成功
                //showToast("请求成功：");
                refuse(result.getResult());
                currentIndex = result.getResult().getNumber();
                allIndex = result.getResult().getTotalPages();

            }

            @Override
            public void onFault(String errorMsg) {
                //失败
                showToast("请求失败："+errorMsg);
            }
        },getContext()));
    }

    private void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refuse() {
        arrayBx.clear();
        getDataList(0);
    }


}
