package com.cookandroid.p_smartorder.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cookandroid.p_smartorder.CustomeActionBar;
import com.cookandroid.p_smartorder.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private Button btnQR, btnSelect;

    //qrcode 스캐너 object
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액션바
        setActionbar();

        //테이블 선택
        btnSelect = findViewById(R.id.btnTblSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TableChoiceActivity.class);
                startActivity(intent);
            }
        });

        //scan object
        qrScan = new IntentIntegrator(this);

        //qr스캔 버튼
        btnQR = findViewById(R.id.btnQR);
        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
            }
        });
    }

    //스캔 결과 출력
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result !=null){
            //qrcode 내용이 명확하지 않을 때
            if(result.getContents()==null){
                Toast.makeText(MainActivity.this, "다시 스캔해주세요", Toast.LENGTH_LONG).show();
            }else { //qrcode 결과가 있을 때
                Toast.makeText(MainActivity.this, "스캔 완료", Toast.LENGTH_LONG).show();

                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("테이블 확인");
                    final String shop = obj.getString("shop");
                    String tel = obj.getString("tel");
                    String addr = obj.getString("address");
                    final String table = obj.getString("table");

                    System.out.println(shop);

                    final String[] qrInfo
                            = new String[] {"가게명: "+shop, "전화번호: "+tel, "주소: "+addr, "테이블: "+table};
                    dlg.setItems(qrInfo, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    dlg.setPositiveButton("주문 진행하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MenuListActivity.class);
                            intent.putExtra("shopName", shop);
                            intent.putExtra("tableNumber", table);
                            startActivity(intent);
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "다시 선택해주세요", Toast.LENGTH_SHORT).show();

                        }
                    });

                    dlg.show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);

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