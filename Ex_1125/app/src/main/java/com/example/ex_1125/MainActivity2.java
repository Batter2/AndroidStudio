package com.example.ex_1125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_view = findViewById(R.id.tv_view);

        // 화면이 전환되었을 때 Main 페이지에서 입력하여 보내준 데이터값(data) 꺼내오기!
        // 데이터값(data) -> intent를 통해 전달
        // getIntent() : 이전화면에서 생성하고 전달하는 Intent를 가져오는 메소드!!
        // getIntent로 받아온 데이터 중 내가 원하는 데이터(String 타입)를 선택해서 꺼내야함
        // main페이지에서 원하는 데이터의 name을 data라고 설정했음
        String msg = getIntent().getStringExtra("data");

        // 받아온 데이터를 msg 변수에 담아주고, 그 데이터를 tv_view에 연결
        tv_view.setText(msg);

        // 양방향 사용 시 결과에 대한 메소드를 수행할 수 있도록 메소드 호출하기!!
        // -> onActivityResult() -> setResult()
        setResult(RESULT_OK);

        // 양방향에 대한 처리가 끝나면 자동으로 요청한 Activity 화면으로 이동!!
        // 성공에 대한 결과값(RESULT_OK)을 담아서 이동!!

        // 성공에 대한 페이지로 이동후 자동으로 Main으로 이동!!
        finish();

    }
}