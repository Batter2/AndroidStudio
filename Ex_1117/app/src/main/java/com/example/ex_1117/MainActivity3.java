package com.example.ex_1117;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    Button btn_pre, btn_next;
    ImageView img;

    // 연속적으로 이미지를 관리하기 위하여 같은 타입으로 관리할 수 있는 배열 생성!!
    // 안드로이드는 파일의 id값, 정보들에 디해 정수형으로 관리하므로 해당하는 이미지 또한
    // 정수형의 배열로 관리!!

    int[] arr = {R.drawable.img11,R.drawable.img22,R.drawable.img33};

    // 이미지의 인덱스 번호를 관리할 변수를 선언

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 1. 각 View(객체)들의 위치값 찾아오기

        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);
        img = findViewById(R.id.img);

        // 3. 각 버튼별 이벤트 연결하기

        btn_pre.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    // 2. 버튼 클릭 시 이벤트 처리하기!!

    @Override
    public void onClick(View view) {

        // 4. 어떤 버튼이 눌렸는지 판단!

        if(view.getId()==R.id.btn_pre){
            if(index==0){
                index=2;
            }
            else{
                index--;
            }
            // 이전 버튼 클릭시 : 0 -> 2 -> 1 -> 0
        }else{
            index++;
            if(index==3){
                index=0;
            }
            // 다음 버튼 클릭시 : 0 -> 1 -> 2 -> 0
        }

        // 공통적으로 img를 띄울 수 있도록 연결

        img.setImageResource(arr[index]);
    }
}