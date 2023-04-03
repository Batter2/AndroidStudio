package com.example.ex_1130;

public class Data {

    // 각각 항목에 들어갈 데이터를 한번에 다룰 수 있는 클래스
    private int img;
    private String name;
    private String cnt;

    public Data(int img, String name, String cnt) {
        this.img = img;
        this.name = name;
        this.cnt = cnt;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }
}
