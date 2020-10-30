package com.cookandroid.p_smartorder.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.cookandroid.p_smartorder.Adapter.CartList_Adapter;
import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.DTO.CartDTO;
import com.cookandroid.p_smartorder.Network.N_CartList;
import com.cookandroid.p_smartorder.Network.N_Sum;
import com.cookandroid.p_smartorder.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CartListActivity extends AppCompatActivity {

    ListView listView;
    CartList_Adapter adapter;
    Button btnOrder;
    String ordernum;
    TextView nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        //액션바
        setActionbar();

        //주문번호 넘어옴
        final Intent intent = getIntent();
        ordernum= intent.getStringExtra("viewOnum");
        nm = findViewById(R.id.txtNum);
        nm.setText(ordernum);

        listView=findViewById(R.id.cartList);
        adapter = new CartList_Adapter(CartListActivity.this, R.layout.list_cart, new ArrayList<CartDTO>());
        listView.setAdapter(adapter);

        new N_CartList((CartList_Adapter) listView.getAdapter()).execute(ordernum);

        btnOrder=findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder ab = new AlertDialog.Builder(CartListActivity.this);
                ab.setMessage("주문을 진행하시겠습니까?");

                //아니오 버튼
                ab.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //주문진행버튼
                ab.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent1 = new Intent(getApplicationContext(), OrderActivity.class);
                        //주문번호넘김
                        intent1.putExtra("ordernum",ordernum);
                        startActivity(intent1);

                    }
                });
                ab.show();
            }
        });
    }

    //액션바 적용
    private void setActionbar(){
        CustomeActionBar ca = new CustomeActionBar(this, getSupportActionBar());
        ca.setActionBar();

        final ImageButton btnCart = findViewById(R.id.btnCart);
        btnCart.setVisibility(View.INVISIBLE);

        final ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}