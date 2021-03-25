package com.joker.listapp.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.joker.listapp.ItemAdapter;
import com.joker.listapp.R;

import java.util.ArrayList;
import java.util.List;

public class TVLayout extends RelativeLayout {

    private final String TAG = "TVLayout";
    private GridView gridView;
    private ListAdapter listAdapter;

    private List<ItemBean> list = new ArrayList<>();
    private String[] colorTypeArr = {"快餐","快饮","火锅","西餐","生鲜"};
    private int[] colorImgTrueArr = {R.drawable.img_fast_food, R.drawable.img_quick_drink,
            R.drawable.img_hotpot, R.drawable.img_western_food,R.drawable.img_fresh};
    private int[] colorImgFalseArr = {R.drawable.img_fast_food_false,R.drawable.img_quick_drink_false,
    R.drawable.img_hotpot_false,R.drawable.img_western_food_false,R.drawable.img_fresh_false};


    public TVLayout(Context context) {
        super(context);

    }
    public TVLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitView(context);
    }

    private void onInitView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.rv_layout,this);
        gridView = findViewById(R.id.layout_grid_view);
        onInitList();
        listAdapter = new ListAdapter(context,list);
        gridView.setAdapter(listAdapter);
        initListener();
        gridView.setFocusable(true);
        int width = gridView.getWidth();
        int height = gridView.getHeight();
        Log.d(TAG, "onInitView() width = "+width +" ,height = "+height);
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
                ListAdapter adapter = (ListAdapter) gridView.getAdapter();
                adapter.notifyDataSetChanged(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onInitList(){
        list.clear();
        for (int i = 0; i < 5 ;i++){
            ItemBean itemBean = new ItemBean();
            itemBean.setImgFalse(colorImgFalseArr[i]);
            itemBean.setImgTrue(colorImgTrueArr[i]);
            itemBean.setText(colorTypeArr[i]);
            list.add(itemBean);
        }
    }



}