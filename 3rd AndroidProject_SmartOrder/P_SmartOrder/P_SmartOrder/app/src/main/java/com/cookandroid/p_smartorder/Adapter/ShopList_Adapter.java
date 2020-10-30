package com.cookandroid.p_smartorder.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookandroid.p_smartorder.R;
import com.cookandroid.p_smartorder.DTO.ShopDTO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopList_Adapter extends BaseAdapter {
    Activity mAct;
    ArrayList<ShopDTO> shopArr;
    int mListLayout;
    LayoutInflater mInflater;

    public ShopList_Adapter(Activity a, int listLayout, ArrayList<ShopDTO> shopListArr){
        mAct = a;
        shopArr = shopListArr;
        mListLayout = listLayout;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<ShopDTO> arrayList){
        shopArr = arrayList;
    }

    @Override
    public int getCount() {
        return shopArr.size();
    }

    @Override
    public Object getItem(int position) {
        return shopArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = mInflater.inflate(mListLayout, parent, false);
        }

        final TextView txtShop = convertView.findViewById(R.id.txtShopName);
        final TextView txtShopAddr = convertView.findViewById(R.id.txtShopAddr);
        final TextView txtShopTel = convertView.findViewById(R.id.txtShopTel);
        final TextView txtNum = convertView.findViewById(R.id.txtNum);


        txtShop.setText(shopArr.get(position).getName());
        txtShopAddr.setText(shopArr.get(position).getAddr());
        txtShopTel.setText(shopArr.get(position).getTel());
        txtNum.setText(shopArr.get(position).getNum());

        final ImageView imgShop = convertView.findViewById(R.id.imgShop);
        String url = shopArr.get(position).getFilename();
        Picasso.get().load(url).into(imgShop);

        return convertView;
    }



}
