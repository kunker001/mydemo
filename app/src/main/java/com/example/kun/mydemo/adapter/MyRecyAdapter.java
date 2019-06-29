package com.example.kun.mydemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kun.mydemo.MyApp;
import com.example.kun.mydemo.R;

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
    public MyRecyAdapter(ArrayList<Baoxiu> datas) {
        this.datas = datas;
    }
    //创建新View，被LayoutManager所调用
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(MyApp.getConText()).inflate(R.layout.item_myrecy,viewGroup,false);
        return new ViewHolder(view);
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
        private final TextView stateView;
        private final TextView dateView;
        private final TextView idView;

        public ViewHolder(View itemView) {
            super(itemView);
            contentView = itemView.findViewById(R.id.item_content);
            addressView = itemView.findViewById(R.id.item_address);
            stateView = itemView.findViewById(R.id.item_state);
            dateView = itemView.findViewById(R.id.item_date);
            idView = itemView.findViewById(R.id.item_title);
        }

        public void update(Baoxiu baoxiu) {
            idView.setText("编号："+baoxiu.getId());
            contentView.setText(baoxiu.getContent() + "");
            int index = baoxiu.getArea() ;
            if(index < 0) index = 0;
            else if(index <=18  )  index -= 10 ;
            else if(index == 20) index = 9;
            else if(index == 30) index = 10;
            else if(index == 40) index = 11;
            addressView.setText(MyApp.getConText().getResources().getStringArray(R.array.areas)[index] + baoxiu.getAddress() + "");
//            stateView.setText(baoxiu.getState() + "");

            stateView.setText(baoxiu.getState().equals("y")?"已经处理":"未处理");
            dateView.setText(baoxiu.getDate() + "");
        }

        public void setClick(View.OnClickListener click){
            idView.setOnClickListener(click);
        }
    }
}
