package com.example.ex_1114;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // onCreate()는 java에서 main()와 동일한 역할을 한다.
    // : 해당 내용을 실행하겠다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 현재 띄어진 텍스트뷰의 위치값을 가져와
        // 새로운 문구로 교체하기!!

        // 1. TextView의 위치 찾아오기 -> View 객체 정의하기

        TextView txt = findViewById(R.id.txt);

        // 2. 찾아온 txt 위치에 원하는 문구로 내용 수정하기
        txt.setText("문구 바꾸기..");
    }
}