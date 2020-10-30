package com.cookandroid.p_smartorder.Network;

import android.os.AsyncTask;

import com.cookandroid.p_smartorder.Adapter.CartList_Adapter;
import com.cookandroid.p_smartorder.Adapter.OrderList_Adapter;
import com.cookandroid.p_smartorder.DTO.CartDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class N_OrderList extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.206.47:8888/01_Android_DB/cartList.jsp";
    //private String URL_Address = "http://192.168.219.104:8080/01_Android_DB/cartList.jsp";
    private OrderList_Adapter oAdapter;

    public N_OrderList(OrderList_Adapter adapter){
        this.oAdapter=adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = ""; //결과값

        try {
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            //전송모드 설정
            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            //content-type
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=utf-8");

            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("ordernum").append("=").append(strings[0]);

            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;

            while ((line=in.readLine())!=null){
                builder.append(line+"\n");
            }
            res = builder.toString();


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ArrayList<CartDTO> cartList = new ArrayList<>();
        int count = 0;

        try{
            count=JsonParser.cartList(s, cartList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(count==0){

        }else {

            oAdapter.setData(cartList);
            oAdapter.notifyDataSetInvalidated();
        }
    }
}
