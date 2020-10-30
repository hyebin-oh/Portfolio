package com.cookandroid.p_smartorder.DTO;

public class CartDTO {
    private String num;
    private String shop;
    private String ordernum;
    private String type;
    private String menu;
    private String count;
    private String total;
    private String temp;

    public CartDTO(String num, String shop, String ordernum, String type, String menu,
                   String count, String total, String temp){
        this.num=num;
        this.shop=shop;
        this.ordernum=ordernum;
        this.type=type;
        this.menu=menu;
        this.count=count;
        this.total=total;
        this.temp=temp;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
