package com.example.ex_1129;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MyListView extends AppCompatActivity {

    ListView my_lv;
    ArrayList<Member> dataArray;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        my_lv = findViewById(R.id.my_lv);
        dataArray = new ArrayList<Member>();

        // 데이터 셋을 만드는 과정
        for(int i=0; i<20; i++){
            dataArray.add(new Member(android.R.drawable.btn_star_big_on,"승환","01012345678"));
        }

        // Adapter의 필요 3가지 정보
        // 1. 띄워질 현재 페이지에 대한 정보
        // 2. 어떤 형식(항목)으로 띄워질지에 대한 정보
        // 3. 데이터 셋

        adapter = new MyAdapter(MyListView.this,R.layout.my_item,dataArray);

        my_lv.setAdapter(adapter);
    }
}