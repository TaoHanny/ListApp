package com.joker.listapp.custom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joker.listapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<ItemBean> list;

    private int selectid = -1;

    public ListAdapter(Context context , List<ItemBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        if(list ==null ) return 0;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBean itemBean = list.get(position);
        View view =  View.inflate(context,R.layout.list_item,null);
        ImageView imageView = view.findViewById(R.id.item_img);
        TextView textView = view.findViewById(R.id.item_name);
        imageView.setImageResource(itemBean.getImgFalse());
        textView.setText(itemBean.getText());
        textView.setTextColor(Color.GRAY);
        view.setBackgroundColor(Color.TRANSPARENT);
        if(selectid == position){
            imageView.setImageResource(itemBean.getImgTrue());
            textView.setTextColor(Color.WHITE);
        }
        return view;
    }

}