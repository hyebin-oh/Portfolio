package com.cookandroid.p_smartorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.cookandroid.p_smartorder.Adapter.CartList_Adapter;
import com.cookandroid.p_smartorder.Adapter.OrderList_Adapter;
import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.DTO.CartDTO;
import com.cookandroid.p_smartorder.Network.N_CartList;
import com.cookandroid.p_smartorder.Network.N_OrderList;
import com.cookandroid.p_smartorder.Network.N_Sum;
import com.cookandroid.p_smartorder.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class OrderActivity extends AppCompatActivity {
    TextView txtOderNumber, txtOrderMoney;
    ListView listView;
    OrderList_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setActionbar();

        //주문번호
        Intent intent = getIntent();
        String ordernumber = intent.getStringExtra("ordernum");
        txtOderNumber = findViewById(R.id.orderNumber);
        txtOderNumber.setText(ordernumber);

        //리스트뷰
        listView = findViewById(R.id.listOrder);
        adapter = new OrderList_Adapter(this, R.layout.list_order, new ArrayList<CartDTO>());
        listView.setAdapter(adapter);

        new N_OrderList((OrderList_Adapter) listView.getAdapter()).execute(ordernumber);

        //총 결제금액
        try {
            JSONObject object = new JSONObject(new N_Sum(OrderActivity.this).execute(ordernumber).get());
            String sum = object.getString("SUM");
            txtOrderMoney = findViewById(R.id.orderMoney);
            txtOrderMoney.setText("결제 금액: "+ sum);
           //txtOrderMoney.setText(sum);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //액션바 적용
    private void setActionbar(){
        CustomeActionBar ca = new CustomeActionBar(this, getSupportActionBar());
        ca.setActionBar();

        final ImageButton btnCart = findViewById(R.id.btnCart);
        btnCart.setVisibility(View.INVISIBLE);

        final ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setVisibility(View.INVISIBLE);

    }
}