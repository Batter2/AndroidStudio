package com.example.ex_1207;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView tv_time, tv_time2;
    Button btn_time;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time = findViewById(R.id.tv_time);
        tv_time2 = findViewById(R.id.tv_time2);
        btn_time = findViewById(R.id.btn_time);

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mythread mythread = new Mythread();
                Mythread2 mythread2 = new Mythread2();
                // Mythread 안에 있는 run 매소드를 실행시켜주세용
                mythread.start();
                mythread2.start();
            }
        });
    } // 여기까지 onCreate

    // Threa에서 요청을 받아 화면에 있는 요소를 조작할 수 있는 Handler!
    Handler myHandler = new Handler(){
        public void handleMessage(@NonNull Message msg){
            if(msg.arg1==0){
                tv_time.setText(String.valueOf(msg.arg2));
            }else if(msg.arg1==1){
                tv_time2.setText(String.valueOf(msg.arg2));
            }
        }
    };

    // 새로운 작업 공간 == 새로운 Thread
    class Mythread extends Thread{
        // run 메소드 오버라이딩 : 새로운 작업공간에서 실행시킬 로직을 정의!

        @Override
        public void run() {
            // 1초마다 1씩 증가하는 출력문 작성!
            try {
                for(int i=0; i<10;i++){
                    // 1초마다 핸들러로 Message 객체를 통해서 요청을 보내야함!
                    Thread.sleep(1000);
                    Log.d("경과시간 ", String.valueOf(i));

                    // Thread에서는 직접적으로 화면에 있는 구성요소(View)를 조작 할 수 없다.

                    // tv_time.setText(String.valueOf(i));
                    Message msg = new Message();
                    msg.arg1 = 0;
                    msg.arg2 = i+1;
                    myHandler.sendMessage(msg); // handlerrMesage로 요청 보내겠습니다.

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    class Mythread2 extends Thread{
        // run 메소드 오버라이딩 : 새로운 작업공간에서 실행시킬 로직을 정의!

        @Override
        public void run() {
            // 1초마다 1씩 증가하는 출력문 작성!
            try {
                for(int i=0; i<10;i++){
                    // 1초마다 핸들러로 Message 객체를 통해서 요청을 보내야함!
                    Thread.sleep(3000);
                    Log.d("경과시간 ", String.valueOf(i));

                    // Thread에서는 직접적으로 화면에 있는 구성요소(View)를 조작 할 수 없다.

                    // tv_time.setText(String.valueOf(i));
                    Message msg = new Message();
                    msg.arg1 = 1;
                    msg.arg2 = i+1;
                    myHandler.sendMessage(msg); // handlerrMesage로 요청 보내겠습니다.

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}