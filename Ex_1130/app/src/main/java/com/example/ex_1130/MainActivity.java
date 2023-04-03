package com.example.ex_1130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainListView extends AppCompatActivity {

    ListView my_lv;
    ArrayList<Member> dataArray;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);

        my_lv = findViewById(R.id.my_lv);
        dataArray = new ArrayList<Member>();

//        String[] nameArray = {"가","나","다"....};

//
//        int[] imgArray= {R.drawable.item1,R.drawable.item2....}
//        for(int i =0; i<nameArray.length; i++){
//
//            Member m =new Member(imgArray[i],nameArray[i],"상품 갯수:10");
//            dataArray.add(m);
//        }
        //android.R.drawable. :안드로이드 기본제공 사진사용하기
        //데이터 셋을 만드는 작업
        dataArray.add(new Member(R.drawable.item1,"텀블러","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item2,"슬리퍼","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item3,"케이스","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item4,"인형","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item5,"피규어","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item6,"안마봉","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item7,"미정","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item8,"미정2","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item9,"미정3","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item10,"미정4","상품개수 :10"));
        dataArray.add(new Member(R.drawable.item11,"미정5","상품개수 :10"));




        //어뎁터의 필요 3가지 정보
        //1. 띄워질 현재 페이지에 대한 정보
        //2. 어떤 형식(항목)으로 띄워질지에 대한 정보
        //3. 데이터 셋
        adapter = new MyAdapter(MainListView.this,R.layout.my_item,dataArray);

        my_lv.setAdapter(adapter);





    }
}