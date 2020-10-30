package com.cookandroid.p_smartorder.Network;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cookandroid.p_smartorder.Activity.MenuViewActivity;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class N_CartAdd extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.206.47:8888/01_Android_DB/cartAdd.jsp";
    //private String URL_Address = "http://192.168.219.104:8080/01_Android_DB/cartAdd.jsp";
    private MenuViewActivity activity;


    public N_CartAdd(MenuViewActivity act){
        this.activity=act;
    }

    @Override
    protected String doInBackground(String... strings) {
        String res="";

        try {
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=utf-8");

            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("shop").append("=").append(strings[0]);
            buffer.append("&ordernum").append("=").append(strings[1]);
            buffer.append("&type").append("=").append(strings[2]);
            buffer.append("&menu").append("=").append(strings[3]);
            buffer.append("&cost").append("=").append(strings[4]);
            buffer.append("&count").append("=").append(strings[5]);
            buffer.append("&total").append("=").append(strings[6]);
            buffer.append("&temp").append("=").append(strings[7]);

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
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int res=0;

        try {
            res=JsonParser.getResultJSON(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(res==0){

        }else {
            Toast.makeText(activity, "장바구니에 추가되었습니다", Toast.LENGTH_LONG).show();
        }
    }
}
