package com.example.ex_1202;

public class Data {

    // 각각 항목에 들어갈 데이터를 한번에 다룰 수 있는 클래스

    private String movie_name;
    private String movie_cnt;
    private String movie_date;

    public Data(String movie_name, String movie_cnt, String movie_date){
        this.movie_name = movie_name;
        this.movie_cnt = movie_cnt;
        this.movie_date = movie_date;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_cnt() {
        return movie_cnt;
    }

    public void setMovie_cnt(String movie_cnt) {
        this.movie_cnt = movie_cnt;
    }

    public String getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(String movie_date) {
        this.movie_date = movie_date;
    }
}
