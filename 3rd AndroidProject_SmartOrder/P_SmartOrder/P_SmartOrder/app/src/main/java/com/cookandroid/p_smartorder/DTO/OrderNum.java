package com.cookandroid.p_smartorder.DTO;

public class OrderNum {
    private String orderNum;

    public OrderNum(String oNum) {
        this.orderNum=oNum;
    }

    public void setDatas(String orderNum){
        this.orderNum=orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }


}
