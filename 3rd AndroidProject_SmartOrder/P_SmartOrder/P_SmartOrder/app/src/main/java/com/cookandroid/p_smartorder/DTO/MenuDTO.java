package com.cookandroid.p_smartorder.DTO;

public class MenuDTO {
    private String menu;
    private String cost;
    private String type;
    private String picture;

    public MenuDTO( String menu, String type, String cost, String picture){
        this.menu=menu;
        this.type=type;
        this.cost=cost;
        this.picture=picture;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
