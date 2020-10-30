package com.cookandroid.p_smartorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.Network.N_CartAdd;
import com.cookandroid.p_smartorder.Network.N_MenuView;
import com.cookandroid.p_smartorder.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MenuViewActivity extends AppCompatActivity {
    TextView txtViewMenu, txtViewCost, txtViewCount, txtViewShop, txtViewOnum, txtViewType;
    ImageButton btnSub, btnPlus;
    Button btnCartAdd, btnOrder;
    RadioGroup radioGroup;
    RadioButton rHot, rIce, rFood;

    //인텐트 값
    String strMenu =null;
    String strCost =null;
    String strShop =null;
    String strONum =null;
    String strType =null;

    int count=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);

        setActionbar();

        //상세보기 위젯
        ImageView imgMenu = findViewById(R.id.imgMenu);
        txtViewMenu = findViewById(R.id.txtViewMenu);
        txtViewCost = findViewById(R.id.txtViewCost);
        txtViewShop = findViewById(R.id.tShop);
        txtViewOnum = findViewById(R.id.tOnum);
        txtViewType = findViewById(R.id.tType);

        Intent intent = getIntent();
        strMenu = intent.getStringExtra("viewMenu");
        strCost = intent.getStringExtra("viewCost");
        strShop = intent.getStringExtra("viewShop");
        strONum = intent.getStringExtra("viewOnum");
        strType = intent.getStringExtra("viewType");

        try {
            JSONObject obj = new JSONObject(new N_MenuView(MenuViewActivity.this).execute(strMenu).get());
            String url = obj.getString("PICTURE");
            Picasso.get().load(url).into(imgMenu);


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        txtViewMenu.setText(strMenu);
        txtViewCost.setText(strCost);
        txtViewShop.setText(strShop);
        txtViewOnum.setText(strONum);
        txtViewType.setText(strType);




        //수량
        txtViewCount=findViewById(R.id.txtCount);

        //라디오버튼
        radioGroup = findViewById(R.id.rGroup);
        rHot = findViewById(R.id.rHot);
        rIce = findViewById(R.id.rIce);
        rFood = findViewById(R.id.food);

        //푸드 탭 라디오그룹 안보이게
        if(strType.equals("food")){
            radioGroup.setVisibility(View.INVISIBLE);
            rFood.setChecked(true);
        }

        //프라푸치노 메뉴는 ice만
        if(strMenu.equals("프라푸치노")){
            rHot.setVisibility(View.INVISIBLE);
        }

        //이미지버튼 바인딩
        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1){
                    count=1;
                }else{
                    count--;
                }
                txtViewCount.setText(""+count);
            }
        });

        btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtViewCount.setText(""+count);
            }
        });

        //주문,장바구니 버튼
        btnCartAdd=findViewById(R.id.btnCartAdd);
        btnCartAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shop = strShop;
                String ordernum = strONum;
                String type = strType;
                String temp = null;
                String menu = strMenu;
                String cost = strCost;
                String count = txtViewCount.getText().toString();
                int tot = (Integer.parseInt(cost)*Integer.parseInt(count));
                String total = String.valueOf(tot);

                if (rHot.isChecked()==true){
                        temp=rHot.getText().toString();
                }
                if(rIce.isChecked()==true){
                    temp=rIce.getText().toString();
                }
                if(rFood.isChecked()==true){
                    temp=rFood.getText().toString();
                }

                new N_CartAdd(MenuViewActivity.this).execute(shop, ordernum, type, menu, cost, count, total, temp);

            }
        });

        //바로주문
        btnOrder=findViewById(R.id.btnOrder);
    }

    //액션바 적용
    private void setActionbar(){
        CustomeActionBar ca = new CustomeActionBar(this, getSupportActionBar());
        ca.setActionBar();

        final ImageButton btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartListActivity.class);

                String ONum = strONum;
                intent.putExtra("viewOnum", ONum);

                startActivity(intent);

            }
        });

        final ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
