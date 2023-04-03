package com.example.ex_1121;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 사용하고자 하는 View 선언하기!

    TextView tv_msg;
    EditText edt_msg; // Plain Text를 선언하기 위해서는 EditText 객체를 사용한다!!
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 각 View의 id값 찾아와서 저장하기

        btn = findViewById(R.id.btn);
        tv_msg = findViewById(R.id.tv_msg);
        edt_msg = findViewById(R.id.edt_msg);

        // 2. btn을 클릭 시 이벤트가 연결되도록 저장하기

        // - 익명클래스 활용!

        // - 입력한 내용(edt_msg)을 가져와서 Log창에 띄우기
        // - getText() : View에 입력된 내용을 가져오는 메소드!

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // edt_msg의 내용 가져오기!
//                // String msg = edt_msg.getText().toString();
//                String msg = String.valueOf(edt_msg.getText());
//                // String msg = edt_msg.getText+"";
//
//                Log.d("check", msg);
//
//                // 입력한 내용 tv_msg에 띄우기
//
//                tv_msg.setText(msg);
//
//                // 입력창 초기화하기
//
//                edt_msg.setText("");
//
//            }
//        });

        // 키보드를 활용한 이벤트 처리하기

        edt_msg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                // key의 액션 상태 -> Up / Down
                // 변수 i는 key code를 판단할 수 있는 변수!!

                if(i==keyEvent.KEYCODE_ENTER){
                    if(keyEvent.getAction()==keyEvent.ACTION_DOWN){
                        Log.d("Check","이벤트 감지");
                        String msg = edt_msg.getText().toString();
                        tv_msg.setText(msg);
                        edt_msg.setText("");
                    }
                }

                // return의 타입 = true : 기존 시스템이 가지는 처리를 무시하고 사용자가 입력한 결과를 처리하는 기능!
                // return의 타입 = false : 기존 시스템의 처리상태대로 진행하는 기능!

                return true;
            }
        });

    }
}