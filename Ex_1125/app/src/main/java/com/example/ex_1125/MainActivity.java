package com.example.ex_1125;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_next, btn2;
    EditText tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_next = findViewById(R.id.btn_next);
        tv_msg = findViewById(R.id.tv_msg);
        btn2 = findViewById(R.id.btn2);

        // 단방향 Intent 사용! (Main -> Next, 한번만 이동)
        // 양방향 Intent (Main <-> Next)

        // 버튼이 눌리면 Main -> Next 화면으로 이동하는 기능 만들기!
        // + 화면전환과 동시에 입력된 text값을 Next페이지로 이동!

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 누르자마자 화면 전환전에 입력된 내용 확인!!
                String msg = tv_msg.getText().toString();

                // Intent 생성
                // new Intent(액션, tel/uri/...)
                // -> new Intent(출발하는 화면(this), 도착하는 화면(class)
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                // Intent 실행 전 담아주고 데이터값 담기!
                // putExtra(매개변수, 매개변수)
                intent.putExtra("data", msg);

                // Intent 실행하기
                startActivity(intent);

                // Next 페이지에서 뒤로가기 클릭 시 이전의 화면(main)이 살아있으면 main으로 이동!!
                // 넘어갈때 이전의 화면인(Main) 종료 시 뒤로가기 진행 시 어플이 종료!
                finish(); // 현재 화면을 종료하는 메소드
            }
        });

        // 양방향에 대한 btn2 이벤트 실행하기!!
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 누르자마자 화면 전환전에 입력된 내용 확인!!
                String msg = tv_msg.getText().toString();

                // btn2 클릭 : main -> next -> main
                // 화면이 계속 전환되므로 Intent 사용!
                // 되돌아 왔을때의 로직을 정리할 메소드 필요!

                // getApplicationContext() : 현재 애플리케이션의 정보를 가져오는 것(=MainActivity.this)
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                intent.putExtra("data",msg);

                startActivityForResult(intent,0);
            }
        });
    }

    // 양방향 진행 시 결과(제대로 결과가 넘어왔을 때!!)에 대한 기능울 수행할 메소드 생성!!
    // onCreate() 메소드와 별개로 생성!!


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 사용자가 요청한 requestCode가 일치하는지 확인
        if(requestCode==0){
            // 결과에 대한 응답 : RESULT_OK, RESULT_CANCLE
            if(resultCode==RESULT_OK){
                Toast.makeText(getApplicationContext(),"양방향 통신이 성공해브렀구만 ㅎㅎ",Toast.LENGTH_SHORT).show();
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"양방향 통신이 실패했엉 ㅠㅠ",Toast.LENGTH_SHORT).show();
            }
        }
    }
}