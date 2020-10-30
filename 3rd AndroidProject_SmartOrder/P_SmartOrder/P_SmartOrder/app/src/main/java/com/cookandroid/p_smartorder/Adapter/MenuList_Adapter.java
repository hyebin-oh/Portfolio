package com.cookandroid.p_smartorder.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookandroid.p_smartorder.DTO.MenuDTO;
import com.cookandroid.p_smartorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuList_Adapter extends BaseAdapter {
    private Activity mAct;
    ArrayList<MenuDTO> menuArr;
    int mListLayout;
    LayoutInflater mInflater;

    public MenuList_Adapter (Activity a, int listLayout, ArrayList<MenuDTO> menuListArr){
        mAct = a;
        menuArr = menuListArr;
        mListLayout = listLayout;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<MenuDTO> arrayList){
        menuArr = arrayList;
    }


    @Override
    public int getCount() {
        return menuArr.size();
    }

    @Override
    public Object getItem(int position) {
        return menuArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = mInflater.inflate(mListLayout, parent,false);
        }

        final TextView txtMenu = convertView.findViewById(R.id.txtMenu);
        txtMenu.setText(menuArr.get(position).getMenu());

        final TextView txtType = convertView.findViewById(R.id.txtType);
        txtType.setText(menuArr.get(position).getType());

        final TextView txtCost = convertView.findViewById(R.id.txtCost);
        txtCost.setText(menuArr.get(position).getCost());

        final ImageView img = convertView.findViewById(R.id.img);
        String url = menuArr.get(position).getPicture();
        Picasso.get().load(url).into(img);

        return convertView;
    }
}
