package com.cookandroid.p_smartorder.Network;

import android.os.AsyncTask;

import com.cookandroid.p_smartorder.Activity.MainActivity;
import com.cookandroid.p_smartorder.Activity.MenuListActivity;
import com.cookandroid.p_smartorder.DTO.ShopDTO;
import com.cookandroid.p_smartorder.Adapter.ShopList_Adapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class N_ShopList extends AsyncTask<String, Void, String> {

    private URL Url;
    private String URL_Address = "http://10.100.206.47:8888/01_Android_DB/shopList.jsp";
    //private String URL_Address = "http://192.168.219.104:8080/01_Android_DB/shopList.jsp";
    private ShopList_Adapter adapter;

    public N_ShopList(ShopList_Adapter adapter){
        this.adapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res="";

        try {
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=utf-8");

            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("name").append("=").append(strings[0]);

            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;

            while ((line=in.readLine())!=null){
                builder.append(line+"\n");
            }
            res = builder.toString();

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

       ArrayList<ShopDTO> shopList = new ArrayList<ShopDTO>();

       int count = 0;

        try {
            count = JsonParser.getShopInfo(s, shopList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(count==0){

        }else {
            adapter.setDatas(shopList);
            adapter.notifyDataSetInvalidated();
        }
    }
}
