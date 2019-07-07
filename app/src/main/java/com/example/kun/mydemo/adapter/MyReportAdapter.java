package com.example.kun.mydemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kun.mydemo.MyApp;
import com.example.kun.mydemo.R;
import com.example.kun.mydemo.utils.AreaFactory;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.util.ArrayList;

public class MyRecyAdapter  extends RecyclerView.Adapter<MyRecyAdapter.ViewHolder> {

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack{
        void onItemClick(int pos);
    }
    public ArrayList<Baoxiu> datas = null;
    private ItemClickCallBack clickCallBack;
    private int type ; //区分status 要不要留下
    public MyRecyAdapter(ArrayList<Baoxiu> datas , int type ) {
        this.datas = datas;
        this.type = type;
    }
    //创建新View，被LayoutManager所调用
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int resouce_id = type == 0 ?R.layout.item_myrecy:R.layout.item_myrecy2;
        View view = LayoutInflater.from(MyApp.getConText()).inflate(resouce_id,viewGroup,false);
        return new ViewHolder(view,type);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        viewHolder.update(datas.get(pos));
        viewHolder.setClick(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickCallBack.onItemClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  datas.size();
    }

    public Baoxiu getItem(int pos){
        return datas.get(pos);
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView contentView;
        private final TextView addressView;
        private  TextView stateView;
        private final TextView dateView;
        private final SuperTextView idView;
        private int type = 0 ;
        public ViewHolder(View itemView , int type) {
            super(itemView);
            this.type = type;
            contentView = itemView.findViewById(R.id.item_content);
            addressView = itemView.findViewById(R.id.item_address);
            if(type == 0)stateView = itemView.findViewById(R.id.item_state);
            dateView = itemView.findViewById(R.id.item_date);
            idView = itemView.findViewById(R.id.item_title);
        }

        public void update(Baoxiu baoxiu) {
            idView.setLeftString("编号："+baoxiu.getId());
            contentView.setText(baoxiu.getContent() + "");
            int index = baoxiu.getArea() ;
            index = AreaFactory.getSpinnerIndex(index);

            addressView.setText(MyApp.getConText().getResources().getStringArray(R.array.areas)[index] + baoxiu.getAddress() + "");
//            stateView.setText(baoxiu.getState() + "");

            if(type == 0)stateView.setText(baoxiu.getState().equals("y")?"已经处理":"未处理");
            dateView.setText(baoxiu.getDate() + "");
        }

        public void setClick(View.OnClickListener click){
            idView.setOnClickListener(click);
        }
    }
}
