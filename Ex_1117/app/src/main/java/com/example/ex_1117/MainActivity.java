package com.example.ex_1117;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // implements View.OnClickListener

    // 모든 메소드에서 View를 사용할 수 있도록 전역변수 선언하기!

    Button btn;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. xml 연결 방식!
        // (1)위치값 찾기

        btn = findViewById(R.id.btn);
        layout = findViewById(R.id.layout);

        // 2. 클래스를 활용한 이벤트 처리!
        // btn.setOnClickListener(this);

        // 3. 익명 클래스를 활용한 이벤트 처리!
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(Color.RED);
            }
        });

    }

//    @Override
//    public void onClick(View view) {
//        layout.setBackgroundColor(Color.GREEN);
//    }

    // 이벤트 감지시 사용할 메소드 생성!

//    public  void onClick(View v){
//        layout.setBackgroundColor(Color.RED);
//    }
}