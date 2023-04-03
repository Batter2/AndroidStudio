package com.example.ex_1208;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_Score;
    Button btn_Start;
    // 이미지뷰 9개를 한번에 다룰 수 있는 배열 생성
    ImageView[] imgArray = new ImageView[9];
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Score = findViewById(R.id.tv_Score);
        btn_Start = findViewById(R.id.btn_Start);

        for (int i = 0; i < imgArray.length; i++) {
            // 이미지 값의 타입 : int
            // img1 ~ img9 까지에 대한 id값이 imgId에 담기게된다!!
            int imgId = getResources().getIdentifier("img" + (i + 1), "id", getPackageName());
            imgArray[i] = findViewById(imgId);

            imgArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // View 객체는 화면에 보여지는 모든 요소에 대한 제일 최상위 객체이다.
                    ImageView img = (ImageView) view;
                    // view를 통해서 사용해 줄때는 다운캐스팅을 해서 사용해주어야함,
                    // 내려가 있는 이미지로 바꾸어주세요.
                    String Result = img.getTag().toString();

                    if(Result.equals("ScoreResult")){
                        score = Integer.parseInt(tv_Score.getText().toString());
                        img.setImageResource(R.drawable.img1);
                        score++;
                        tv_Score.setText(score+"");
                        img.setTag("");
                    }
                }
            });
        }

        // btn_Start, tv_Score, imgArray : 객체 준비완료!!

        //1. 버튼을 클릭했을때 이미지가 랜덤시간이 지난뒤 올라온이미지로 바뀌게 해주세요!
        //2. 이미지를 클릭 했을때 내려간 이미지로 만들기

        //3. 이미지를 클릭했다면 다면 SCORE 값이 1증가
        //4. 올라온 이미지를 클릭했을때만 SCORE 값이 1 증가
        //(현재 이미지가 내려가있는 이미지인지 올라와 있는 이미지 인지 판별 해줘야함!)

        //5. 계속 반복 되게 이미지 변경 될 수 있도록
        //6. score 값이 30이라면 이제 그만

        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < imgArray.length; i++) {
                    // TimeThread이라는 쓰레드 시작
                    TimeThread thread = new TimeThread(i);
                    thread.start();
                }
            }
        });
    }

    Handler TimeHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 이미지뷰를 올라온두더지이미지로 변경
            imgArray[msg.arg1].setImageResource(R.drawable.img2);
            imgArray[msg.arg1].setTag("ScoreResult");
        }
    };


    // 각각의 이미지가 랜덤한 시간을 셀 수 있도록 도와주는 쓰레드
    class TimeThread extends Thread {

        int pos;
        private boolean stop;

        // 생성자 : 데이터를 저장
        public TimeThread(int pos) {
            this.pos = pos;
        }

//        public void setStop(boolean stop){
//            this.stop=stop;
//        }

        @Override
        public void run() {

            // 1 ~ 10사이의 랜덤값
            Random random = new Random();
            int randomTime = random.nextInt(10) + 1;

            while (score<30){
                try {

                    // 랜덤한 시간을 기다려주세요
                    Thread.sleep(randomTime * 500);
                    // 랜덤한 시간이 흐른 올라온 두더지이미지로 변경
                    // 쓰레드라서 조작을 할 수 없다 -> handler로 요청을 보내서 조작해야함!!
                    // 요청내용 : 몇 번째 이미지인지(몇 번째 배열인지)
                    Message msg = new Message();
                    msg.arg1 = pos;
                    TimeHandler.sendMessage(msg);
                    // 요청내용 : 어떤 이미지로 바꿀지

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    score=30;
                }

            }


        }
    }
}