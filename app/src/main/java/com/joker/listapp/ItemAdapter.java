package com.joker.listapp;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private int layoutId;
    private List<ItemBean> list;
    private Context context;
    private int selectid = -1;
    private boolean firstStart = true;

    public ItemAdapter(@NonNull Context context, @NonNull List<ItemBean> list) {

        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void notifyDataSetChanged(int id) {
        selectid = id;
        super.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ItemBean itemBean = list.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        ImageView imageView = view.findViewById(R.id.item_img);
        TextView textView = view.findViewById(R.id.item_name);
        imageView.setImageResource(itemBean.getImgFalse());
        textView.setText(itemBean.getText());

        if(selectid == position){
            Log.d("ItemAdapter", "getView()  selectId = "+selectid);
            Animation testAnim = AnimationUtils.loadAnimation(context, R.anim.item_list_anim);
            view.startAnimation(testAnim);
            view.setScaleX((float) 1.1);
            view.setScaleY((float)1.1);
            imageView.setImageResource(itemBean.getImgTrue());
            textView.setTextSize(18);
            textView.setTextColor(Color.rgb(222,159,55));

        }else {
            view.setScaleY(1);
            view.setScaleX(1);
            imageView.setFocusable(false);
            textView.setFocusable(false);
            textView.setTextSize(16);
            imageView.setImageResource(itemBean.getImgFalse());
            textView.setTextColor(Color.rgb(255,255,255));
        }

        return view;
    }

    //对所有View都可执行的放大动画
    private void setViewZoomIn(View v){
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation animation = new ScaleAnimation(1.0f,1.1f,1.0f,1.1f,
                Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(350);//动画效果时间
        animation.setFillAfter(true);
        animationSet.addAnimation(animation);
        animationSet.setFillAfter(true);
        v.clearAnimation();
        v.startAnimation(animationSet);
    }
    //对所有View都可执行的缩小动画
    private  void setViewZoomOut(View v){
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation animation = new ScaleAnimation(1.1f,1.0f,1.1f,1.0f,
                Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(350);//动画效果时间
        animation.setFillAfter(true);
        animationSet.addAnimation(animation);
        animationSet.setFillAfter(true);
        v.clearAnimation();
        v.startAnimation(animationSet);
    }
}