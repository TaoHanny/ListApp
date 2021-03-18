package com.joker.listapp;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class TVRelativeLayout extends RelativeLayout {


    private List<ItemBean> list = new ArrayList<>();
    private GridView gridView;
    private ItemAdapter itemAdapter;
    private String[] name = {"自动模式","餐饮模式","服饰模式","人像模式","自定义模式"};
    private int[] resourceIDTrue = {R.drawable.img_automatic_true, R.drawable.img_food_true,
            R.drawable.img_dress_true,R.drawable.img_figure_true,R.drawable.img_custom_true};
    private int[] resourceIDFalse = {R.drawable.img_automatic_false, R.drawable.img_food_false,
            R.drawable.img_dress_false,R.drawable.img_figure_false,R.drawable.img_custom_false};


    public TVRelativeLayout(Context context) {
        super(context);

    }

    public TVRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.tv_relativelayout,this);
        gridView = findViewById(R.id.layout_grid_view);
        list = getDataList();
        itemAdapter = new ItemAdapter(context,list);
        initListener();
        gridView.setAdapter(itemAdapter);
        gridView.setFocusable(true);
    }

    private void initListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemAdapter adapter = (ItemAdapter) gridView.getAdapter();
                adapter.notifyDataSetChanged(position);
            }
        });


        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //对适配器进行刷新
                Log.d("TAG", "onItemSelected: position = "+position);
                ItemAdapter adapter = (ItemAdapter) gridView.getAdapter();
                adapter.notifyDataSetChanged(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<ItemBean> getDataList() {

        list.clear();
        for (int i = 0 ; i < 5 ; i++ ){
            ItemBean itemBean = new ItemBean();
            itemBean.setImgTrue(resourceIDTrue[i]);
            itemBean.setImgFalse(resourceIDFalse[i]);
            itemBean.setText(name[i]);
            list.add(itemBean);
        }
        return list;
    }


}