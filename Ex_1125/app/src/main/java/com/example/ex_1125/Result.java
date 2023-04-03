package com.example.ex_1125;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    TextView Result, Result2, Result_login;
    String nick = "집가고싶다리...";
    Button Result_main;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Result = findViewById(R.id.Result);
        Result2 = findViewById(R.id.Result2);
        Result_login=findViewById(R.id.Result_login);
        Result_main=findViewById(R.id.Result_main);

        // 화면이 전환되었을 때 Login 페이지에서 입력하여 보내준 데이터 꺼내오기
        // getIntet() : Login 화면에서 생성하고 전달한 Intent를 가져오는 메소드
        String Result_ID = getIntent().getStringExtra("data_ID");
        String Result_PW = getIntent().getStringExtra("data_PW");

        if(Result_ID.equals("smhrd")&&Result_PW.equals("123")){
            Result_login.setText("로그인성공");
            Result.setText(Result_ID);
            Result2.setText(Result_PW);
        }else{
            Result_login.setText("로그인실패");
            Result.setText(Result_ID);
            Result2.setText(Result_PW);
        }

        Result_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if(Result_login.getText().toString().equals("로그인성공")){
                    intent.putExtra("data",nick);
                    setResult(RESULT_OK,intent);
//                    Toast.makeText(getApplicationContext(),nick,Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("data","로그인실패");
                    setResult(RESULT_CANCELED,intent);
//                    Toast.makeText(getApplicationContext(),"로그인실패",Toast.LENGTH_SHORT).show();
                }
//                Log.d("dd","가나다라");
                finish();
            }
        });
    }
}