package com.cookandroid.p_smartorder.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cookandroid.p_smartorder.DTO.CartDTO;
import com.cookandroid.p_smartorder.Network.N_CartDelete;
import com.cookandroid.p_smartorder.Network.N_CartList;
import com.cookandroid.p_smartorder.R;

import java.util.ArrayList;

public class OrderList_Adapter extends BaseAdapter {
    Activity mAct;
    LayoutInflater mInflater;
    ArrayList<CartDTO> mCartObjectArr;
    int mListLayout;

    public OrderList_Adapter(Activity a, int listLayout, ArrayList<CartDTO> cartArrayList){
        mAct=a;
        mCartObjectArr=cartArrayList;
        mListLayout=listLayout;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<CartDTO> arrayList){
        mCartObjectArr = arrayList;
    }


    @Override
    public int getCount() {
        return  mCartObjectArr.size();
    }

    @Override
    public Object getItem(int position) {
        return mCartObjectArr.get(position);
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

        final TextView cartMenu = (TextView) convertView.findViewById(R.id.cartMenu);
        cartMenu.setText(mCartObjectArr.get(position).getMenu());

        final TextView cartType = convertView.findViewById(R.id.cartType);
        cartType.setText(mCartObjectArr.get(position).getType());

        final TextView cartCount = convertView.findViewById(R.id.cartCount);
        cartCount.setText("수량: "+mCartObjectArr.get(position).getCount());

        final TextView cartTotal = convertView.findViewById(R.id.cartCost);
        cartTotal.setText(mCartObjectArr.get(position).getTotal());

        final TextView cartTemp = convertView.findViewById(R.id.cartTemp);
        cartTemp.setText(mCartObjectArr.get(position).getTemp());

        //히든값
        final TextView tonum = convertView.findViewById(R.id.tonum);
        tonum.setText(mCartObjectArr.get(position).getOrdernum());

        final TextView tnum= convertView.findViewById(R.id.tnum);
        tnum.setText(mCartObjectArr.get(position).getNum());

        return convertView;
    }
}
