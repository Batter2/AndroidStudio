package com.example.ex_1122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    // 변수 지정

    ImageView img;
    Button btn_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // id값 찾아오기

        img = findViewById(R.id.img);
        btn_change = findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // img의 상태에 따라 다시 띄우거나(VISIBLE)나 감추는(INVISIBLE) 기능 만들기!
                if(img.getVisibility()==view.VISIBLE){

                    // 이미지 감추기!

                    img.setVisibility(View.INVISIBLE);

                    // 버튼의 텍스트 수정 -> "VISIBLE"

                    btn_change.setText("VISIBLE");

                }else if(img.getVisibility()==view.INVISIBLE){

                    // 이미지 띄우기!

                    img.setVisibility(View.VISIBLE);

                    // 버튼의 텍스트 -> "INVISIBLE"

                    btn_change.setText("INVISIBLE");

                }

            }
        });
    }
}