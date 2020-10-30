package com.cookandroid.p_smartorder.Network;

import com.cookandroid.p_smartorder.DTO.CartDTO;
import com.cookandroid.p_smartorder.DTO.MenuDTO;
import com.cookandroid.p_smartorder.DTO.ShopDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    //메뉴리스트
    static public int getMenuInfo(String response, ArrayList<MenuDTO> menuList) throws JSONException {
        String strMenu;
        String strType;
        String strCost;
        String strPicture;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        //전체리스트
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if(jsonObj.getString("MENU").toString().equals("null")){
                strMenu = "-";
            }else {
                strMenu = jsonObj.getString("MENU").toString();
            }

            if(jsonObj.getString("TYPE").toString().equals("null")){
                strType = "-";
            }else {
                strType = jsonObj.getString("TYPE").toString();
            }

            if(jsonObj.getString("COST").toString().equals("null")){
                strCost = "-";
            }else {
                strCost = jsonObj.getString("COST").toString();
            }

            if(jsonObj.getString("PICTURE").toString().equals("null")){
                strPicture= "-";
            }else {
                strPicture = jsonObj.getString("PICTURE").toString();
            }

            menuList.add(new MenuDTO(strMenu, strType, strCost, strPicture));
        }

        return jsonArray.length();
    }

    //메뉴 상세조회
    static public JSONObject viewMenu(String response) throws JSONException{
        JSONObject rootJSON = new JSONObject(response);
        return rootJSON;
    }

    //가게리스트
    static public int getShopInfo(String response, ArrayList<ShopDTO> shopList) throws JSONException{

        String intNum;
        String strShop;
        String strTel;
        String strAddr;
        String strImg;

        JSONObject rootJSON = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if(jsonObj.getString("NUM").toString().equals("null")){
                intNum="-";
            }else {
                intNum = jsonObj.getString("NUM");
            }

            if(jsonObj.getString("NAME").toString().equals("null")){
                strShop="-";
            }else {
                strShop = jsonObj.getString("NAME").toString();
            }

            if(jsonObj.getString("TEL").toString().equals("null")){
                strTel="-";
            }else {
                strTel = jsonObj.getString("TEL").toString();
            }

            if(jsonObj.getString("ADDR").toString().equals("null")){
                strAddr="-";
            }else {
                strAddr = jsonObj.getString("ADDR").toString();
            }

            if(jsonObj.getString("FILENAME").toString().equals("null")){
                strImg="-";
            }else {
                strImg = jsonObj.getString("FILENAME").toString();
            }

            shopList.add(new ShopDTO(intNum, strShop, strTel, strAddr,strImg));
        }

        return jsonArray.length();
    }

    //주문번호
    static public String getOrderNum(String response) throws JSONException {
        String oNum;
        JSONObject rootJSON = new JSONObject(response);

        if(rootJSON.getString("NUM").toString().equals("null")){
            oNum="-";
        }else {
            oNum = rootJSON.getString("NUM");
        }
        return oNum;
    }

    //장바구니 리스트
    static public int cartList(String response, ArrayList<CartDTO> cartList) throws Exception{
        String strNum;
        String strShop;
        String strOdernum;
        String strType;
        String strMenu;
        String strCount;
        String strTotal;
        String strTemp;

        JSONObject rootJSON =  new JSONObject(response);
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for (int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if(jsonObj.getString("NUM").toString().equals("null")){
                strNum="-";
            }else{
                strNum=jsonObj.getString("NUM").toString();
            }

            if(jsonObj.getString("SHOP").toString().equals("null")){
                strShop="-";
            }else{
                strShop=jsonObj.getString("SHOP").toString();
            }

            if(jsonObj.getString("ORDERNUM").toString().equals("null")){
                strOdernum="-";
            }else{
                strOdernum=jsonObj.getString("ORDERNUM").toString();
            }

            if(jsonObj.getString("TYPE").toString().equals("null")){
                strType="-";
            }else{
                strType=jsonObj.getString("TYPE").toString();
            }

            if(jsonObj.getString("MENU").toString().equals("null")){
                strMenu="-";
            }else{
                strMenu=jsonObj.getString("MENU").toString();
            }

            if(jsonObj.getString("COUNT").toString().equals("null")){
                strCount="-";
            }else{
                strCount=jsonObj.getString("COUNT").toString();
            }

            if(jsonObj.getString("TOTAL").toString().equals("null")){
                strTotal="-";
            }else{
                strTotal=jsonObj.getString("TOTAL").toString();
            }

            if(jsonObj.getString("TEMP").toString().equals("null")){
                strTemp="-";
            }else{
                strTemp=jsonObj.getString("TEMP").toString();
            }

            cartList.add(new CartDTO(strNum, strShop, strOdernum, strType, strMenu, strCount, strTotal, strTemp));

        }
        return jsonArray.length();
    }

    static public JSONObject getSum(String response) throws JSONException {
        JSONObject rootJSON = new JSONObject(response);

        return rootJSON;
    }


    static public int getResultJSON(String response) throws JSONException{
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));

        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }
}
