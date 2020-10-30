package com.cookandroid.p_smartorder.Network;

import android.os.AsyncTask;

import com.cookandroid.p_smartorder.Activity.MenuViewActivity;

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

public class N_MenuView extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.206.47:8888/01_Android_DB/menuView.jsp";
    //private String URL_Address = "http://192.168.219.104:8080/01_Android_DB/menuView.jsp";
    MenuViewActivity act;

    public N_MenuView(MenuViewActivity mAct){
        this.act=mAct;
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
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=UTF-8");

            //전송값 설정
            StringBuffer buffer = new StringBuffer();
            buffer.append("MENU").append("=").append(strings[0]);

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

    protected void onPostExecute(String s) {
        super.onPostExecute(s);


        JSONObject menu = new JSONObject();

        try {
            menu = JsonParser.viewMenu(s);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
