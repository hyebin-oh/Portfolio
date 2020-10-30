package com.cookandroid.p_smartorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.DTO.MenuDTO;
import com.cookandroid.p_smartorder.Adapter.MenuList_Adapter;
import com.cookandroid.p_smartorder.Network.N_MenuList;
import com.cookandroid.p_smartorder.Network.N_oderNum;
import com.cookandroid.p_smartorder.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MenuListActivity extends AppCompatActivity {
    TabHost tabHost;

    ListView listView1, listView2, listView3;
    MenuList_Adapter adapter;
    TextView txtShop, txtTable, txtNum;

    //테이블 선택 인텐트
    String shop ="";
    String table ="";

    //주문번호 시퀀스
    String num="";

    public void setDatas(String count){
        this.num=count;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        setActionbar();

        //가게명과 테이블명
        txtShop = findViewById(R.id.txtShop);
        txtTable = findViewById(R.id.txtTable);
        txtNum = findViewById(R.id.txtNum);

        //테이블선택 액티비티 인텐트
        Intent intent = getIntent();
        shop = intent.getStringExtra("shopName");
        table = intent.getStringExtra("tableNumber");
        txtShop.setText("지점명:" +shop);
        txtTable.setText("테이블: " +table);

        //카트리스트로 테이블 넘기기
        Intent cartIntent = new Intent(getApplicationContext(),CartListActivity.class);
        cartIntent.putExtra("tNum", table);

        //주문번호
        try {
          JSONObject obj
                  = new JSONObject(new N_oderNum(MenuListActivity.this).execute().get());
          String a =  obj.getString("NUM");
            txtNum.setText(" / 주문번호: "+table+"-"+a);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //탭 구성
        tabHost = findViewById(R.id.tabHost1);
        tabHost.setup();

        TabHost.TabSpec tabSpecCafein = tabHost.newTabSpec("cafein").setIndicator("커피음료");
        tabSpecCafein.setContent(R.id.tabCafein);
        tabHost.addTab(tabSpecCafein);

        TabHost.TabSpec tabSpecFruit = tabHost.newTabSpec("fruit").setIndicator("과일음료");
        tabSpecFruit.setContent(R.id.tabFruit);
        tabHost.addTab(tabSpecFruit);

        TabHost.TabSpec tabSpecFood = tabHost.newTabSpec("food").setIndicator("푸드");
        tabSpecFood .setContent(R.id.tabFood);
        tabHost.addTab(tabSpecFood);

        tabHost.setCurrentTab(0);

        //커피메뉴 탭
        listView1 = (ListView)findViewById(R.id.tabCafein);
        adapter = new MenuList_Adapter(MenuListActivity.this, R.layout.list_menulist, new ArrayList<MenuDTO>());
        listView1.setAdapter(adapter);
        String typeCafein = tabSpecCafein.getTag();
        new N_MenuList((MenuList_Adapter) listView1.getAdapter()).execute(typeCafein);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MenuViewActivity.class);

                //지점명, 주문번호
                String strShop = shop;
                String strONum = txtNum.getText().toString();

                //리스트뷰의 메뉴명, 가격, 타입
                TextView tMenu = view.findViewById(R.id.txtMenu);
                TextView tCost = view.findViewById(R.id.txtCost);
                TextView tType = view.findViewById(R.id.txtType);

                String strMenu = tMenu.getText().toString();
                String strCost = tCost.getText().toString();
                String strType = tType.getText().toString();

                //뷰화면으로 넘기기
                intent.putExtra("viewShop", strShop);
                intent.putExtra("viewOnum", strONum);
                intent.putExtra("viewMenu", strMenu);
                intent.putExtra("viewCost", strCost);
                intent.putExtra("viewType", strType);

                startActivity(intent);
            }
        });

        //과일음료 탭
        listView2 = (ListView)findViewById(R.id.tabFruit);
        adapter = new MenuList_Adapter(MenuListActivity.this, R.layout.list_menulist, new ArrayList<MenuDTO>());
        listView2.setAdapter(adapter);
        String typeFruit= tabSpecFruit.getTag();
        new N_MenuList((MenuList_Adapter) listView2.getAdapter()).execute(typeFruit);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MenuViewActivity.class);

                //지점명, 주문번호
                String strShop = shop;
                String strONum = txtNum.getText().toString();

                //리스트뷰의 메뉴명, 가격, 타입
                TextView tMenu = view.findViewById(R.id.txtMenu);
                TextView tCost = view.findViewById(R.id.txtCost);
                TextView tType = view.findViewById(R.id.txtType);

                String strMenu = tMenu.getText().toString();
                String strCost = tCost.getText().toString();
                String strType = tType.getText().toString();

                //뷰화면으로 넘기기
                intent.putExtra("viewShop", strShop);
                intent.putExtra("viewOnum", strONum);
                intent.putExtra("viewMenu", strMenu);
                intent.putExtra("viewCost", strCost);
                intent.putExtra("viewType", strType);
                startActivity(intent);
            }
        });

        listView3 = (ListView)findViewById(R.id.tabFood);
        adapter = new MenuList_Adapter(MenuListActivity.this, R.layout.list_menulist, new ArrayList<MenuDTO>());
        listView3.setAdapter(adapter);
        String typeFood = tabSpecFood.getTag();
        new N_MenuList((MenuList_Adapter) listView3.getAdapter()).execute(typeFood);

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MenuViewActivity.class);

                //지점명, 주문번호
                String strShop = shop;
                String strONum = txtNum.getText().toString();

                //리스트뷰의 메뉴명, 가격, 타입
                TextView tMenu = view.findViewById(R.id.txtMenu);
                TextView tCost = view.findViewById(R.id.txtCost);
                TextView tType = view.findViewById(R.id.txtType);

                String strMenu = tMenu.getText().toString();
                String strCost = tCost.getText().toString();
                String strType = tType.getText().toString();

                //뷰화면으로 넘기기
                intent.putExtra("viewShop", strShop);
                intent.putExtra("viewOnum", strONum);
                intent.putExtra("viewMenu", strMenu);
                intent.putExtra("viewCost", strCost);
                intent.putExtra("viewType", strType);
                startActivity(intent);
            }
        });

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

                String strONum = txtNum.getText().toString();
                intent.putExtra("viewOnum", strONum);

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

