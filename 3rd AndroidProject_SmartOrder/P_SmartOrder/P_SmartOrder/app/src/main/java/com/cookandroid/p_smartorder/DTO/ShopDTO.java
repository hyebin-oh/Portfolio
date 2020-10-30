package com.cookandroid.p_smartorder.DTO;

public class ShopDTO {
    private String num;
    private String name;
    private String tel;
    private String filename;
    private String addr;

    public ShopDTO(String num, String name, String tel, String addr, String filename){
        this.num=num;
        this.name=name;
        this.tel=tel;
        this.tel=addr;
        this.filename=filename;
    }

    public String getNum() {
        return num;
    }

    public String setNum(String num) {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
