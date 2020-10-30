package com.cookandroid.p_smartorder.Network;

import android.os.AsyncTask;

import com.cookandroid.p_smartorder.Adapter.CartList_Adapter;

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

public class N_CartDelete extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.206.47:8888/01_Android_DB/cartDelete.jsp";
    //private String URL_Address = "http://192.168.219.104:8080/01_Android_DB/cartDelete.jsp";

    private CartList_Adapter mAdapter;

    public N_CartDelete(CartList_Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res = "";

        try {
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            StringBuffer buffer = new StringBuffer();
           // buffer.append("ordernum").append("=").append(strings[0]);
            buffer.append("num").append("=").append(strings[0]);


            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;

            while ((line = in.readLine()) != null) {
                builder.append(line + "\n");
            }
            res = builder.toString();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  res;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int res = 0;
        try {
            res = JsonParser.getResultJSON(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (res == 0) {
            //result_ok==0

        } else {
            //new N_CartList(adapter).equals("");
        }
    }


}
