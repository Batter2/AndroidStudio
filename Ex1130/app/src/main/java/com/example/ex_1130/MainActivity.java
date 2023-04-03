package com.example.ex_1130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView my_lv;
    ArrayList<Data> dataArray;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView() 함수 : xml을 객체화시키는 inflate동작
        // setContentView() 함수 밑에서 xml에 배치했던 UI 요소들을 마음껏 끌어와 쓸 수 있음
        setContentView(R.layout.activity_main);

        my_lv = findViewById(R.id.my_lv);
        dataArray = new ArrayList<Data>();

        dataArray.add(new Data(R.drawable.item1,"텀블러","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item2,"슬리퍼","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item3,"케이스","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item4,"인형","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item5,"피규어","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item6,"안마봉","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item7,"마우스패드","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item8,"몰루","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item9,"필통","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item10,"파우치","상품개수 : 10"));
        dataArray.add(new Data(R.drawable.item11,"티셔츠","상품개수 : 10"));

        adapter = new MyAdapter(MainActivity.this,
                R.layout.activity_my_item,dataArray);

        my_lv.setAdapter(adapter);

    }
}