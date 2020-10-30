package com.cookandroid.p_smartorder.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.Network.N_ShopList;
import com.cookandroid.p_smartorder.R;
import com.cookandroid.p_smartorder.DTO.ShopDTO;
import com.cookandroid.p_smartorder.Adapter.ShopList_Adapter;

import java.util.ArrayList;

public class TableChoiceActivity extends AppCompatActivity {

    //table choice 위젯
    LinearLayout tableChoice, searchShop;
    EditText edtSearch;
    ListView listView;
    Button btnSearch, btnResearch;
    Button btnT1, btnT2, btnT3, btnT4, btnT5;
    TextView txtSearch, txtShopNumber;
    ShopList_Adapter adapter;
    String searching;//검색어

    //샵리스트 위젯
    TextView txtShopName, txtShopNum;
    String shopName; //리스트뷰의 선택한 샵
    String shopNum; //리스트뷰의 선택한 샵의 넘버

    //
    String num="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_choice);

        //액션바
        setActionbar();

        //text 바인딩
        txtSearch=findViewById(R.id.txtSearch);//테이블선택시 보이는 지점명
        txtShopNumber=findViewById(R.id.txtShopNum);//테이블선택시 지점 번호

        //리스트뷰 바인딩
        listView = findViewById(R.id.listShop);

        //레이아웃 바인딩
        searchShop = findViewById(R.id.serachShopLayout);
        tableChoice = findViewById(R.id.tableChoiceLayout);



        //검색 버튼
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           edtSearch = findViewById(R.id.edtSearch); //검색어 바인딩
           searching = edtSearch.getText().toString();//검색어

           //리스트뷰
           adapter = new ShopList_Adapter(TableChoiceActivity.this, R.layout.list_shoplist, new ArrayList<ShopDTO>());
           listView.setAdapter(adapter);
           searchShop.setVisibility(View.VISIBLE);//리스트뷰 보이게 설정
           new N_ShopList((ShopList_Adapter) listView.getAdapter()).execute(searching);//db검색
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //리스트뷰의 샵 네임
                txtShopName= view.findViewById(R.id.txtShopName);
                shopName = txtShopName.getText().toString();
                txtSearch.setText(shopName); //테이블 선택할 때 지점명 표시

                //샵 번호
                txtShopNum = view.findViewById(R.id.txtNum);
                shopNum = txtShopNum.getText().toString();
                txtShopNumber.setText(shopNum);

                //반갑습니다 안보이게
                TextView txtHi = findViewById(R.id.txtHello);
                txtHi.setVisibility(View.INVISIBLE);
                tableChoice.setVisibility(View.VISIBLE); //테이블 선택 레이아웃 보이게 설정
                searchShop.setVisibility(View.GONE); //검색 레이아웃 안보이게 설정


            }
        });

        //다시 검색 버튼 -> 테이블 선택 invisible
        btnResearch = findViewById(R.id.btnResearch);
        btnResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableChoice.setVisibility(View.INVISIBLE);
                searchShop.setVisibility(View.VISIBLE);
            }
        });

        //버튼 바인딩
        btnT1 = findViewById(R.id.btnTable1);
        btnT2 = findViewById(R.id.btnTable2);
        btnT3 = findViewById(R.id.btnTable3);
        btnT4 = findViewById(R.id.btnTable4);
        btnT5 = findViewById(R.id.btnTable5);

        final Button[] tableNum = {btnT1, btnT2, btnT3, btnT4, btnT5};

        for(int i=0; i<tableNum.length; i++){

            final String tableNumber = tableNum[i].getText().toString(); //테이블 번호

            tableNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder dlg = new AlertDialog.Builder(TableChoiceActivity.this);
                    dlg.setTitle("테이블 확인");
                    final String[] check = new String[] {"지점명: "+shopName, "테이블: "+tableNumber};

                    dlg.setItems(check, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    dlg.setPositiveButton("주문 진행하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MenuListActivity.class);
                            intent.putExtra("shopName", shopName);
                            intent.putExtra("tableNumber", tableNumber);
                            startActivity(intent);
                        }
                    }).setNegativeButton("다시 선택하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(TableChoiceActivity.this, "다시 선택해주세요", Toast.LENGTH_SHORT).show();

                        }
                    });


                    dlg.show();
                }
            });
        }
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