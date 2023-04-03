package com.example.ex_1114;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 1. ImageView의 id값 찾아오기
        // : ImageView 타입의 img 변수명에 해당 값 저장하기

        ImageView img = findViewById(R.id.img);

        img.setVisibility(View.VISIBLE);

        // 2. Log 사용하기

        TextView txt2 = findViewById(R.id.txt2);

        // txt2가 담고있는 문구 가져오기
        // setText() : 문구를 지정하기 위하여 사용!
        // getText() : 작성된 문구를 가져오기 위하여 사용!
        String msg = txt2.getText().toString();
        Log.d("check",msg);
    }
}