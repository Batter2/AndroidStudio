package com.example.ex_1122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 1. View 선언(변수 선언)

    TextView score1, score2;
    ImageView dice1, dice2;
    Button btn;

    // 2. 주사위 이미지를 관리할 배열을 생성

     int[] arr = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3.View id 값 찾아오기

        score1=findViewById(R.id.score1);
        score2=findViewById(R.id.score2);
        dice1=findViewById(R.id.dice1);
        dice2=findViewById(R.id.dice2);
        btn=findViewById(R.id.btn);

        // 4. btn에 이벤트 달기

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 4-1. 주사위의 이미지 변경하기
                // 랜덤으로 주사위의 눈을 생성하기!!

                Random rd = new Random();

                int rd1=rd.nextInt(6);
                int rd2=rd.nextInt(6);

                // 생성된 랜덤값을 실제 주사위 이미지에 연결하기!

                dice1.setImageResource(arr[rd1]);
                dice2.setImageResource(arr[rd2]);

                // 4-2 주사위의 눈을 비교하여 점수 배당하기
                // 두 수 중 어떤 수가 더 큰지 비교하여 TextView에 전달하기
                // dice1 > dice2 => score1=1, score2=0 => score1.setText(점수)

                int num1 =Integer.parseInt(score1.getText().toString());
                int num2 =Integer.parseInt(score2.getText().toString());

                if(rd1>rd2){
                    num1++;
                }else if(rd1<rd2){
                    num2++;
                }

                // 둘 중에 한 명이 5점을 달성한 경우 게임 종료 -> Toast 메시지 사용
                // Toast.makeText(어플의 정보. 메시지 문구(String), 메시지를 띄우는 방법).show();

                if(num1==5){
                    Toast.makeText(getApplicationContext(),"user1님 승리!",Toast.LENGTH_SHORT).show();
                }else if(num2==5){
                    Toast.makeText(getApplicationContext(),"user2님 승리!",Toast.LENGTH_SHORT).show();
                }

                score1.setText(num1+"");
                score2.setText(num2+"");
            }
        });
    }
}