package com.example.ex_1125;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn_login;
    EditText ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        ID = findViewById(R.id.ID);
        PW = findViewById(R.id.PW);

        // 버튼을 누르면 입력한 ID와 PW의 데이터를 가지고 Result 페이지로 이동

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Login_ID = ID.getText().toString();
                String Login_PW = PW.getText().toString();

                // Intent 생성, 출발하는화면(this)&도착하는화면(class)
                Intent intent = new Intent(Login.this,Result.class);

                // Intent 실행 전 데이터 담기
                // putExtra(매개변수, 매개변수)
                intent.putExtra("data_ID", Login_ID);
                intent.putExtra("data_PW", Login_PW);

                // Intent 실행하기
                startActivityForResult(intent,0);
            }
        });
    }

//       onActivityReslt : 결과를 받아와서 실행시키겠습니다.
//       requestCode : 보낸 페이지의 코드
//       resultCode : 결과에 대한 확인 코드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        String data_nick = data.getStringExtra("data");
//        Log.d("dd","가나다라");
        if(requestCode==0){
            if(resultCode==RESULT_OK){
                Toast.makeText(getApplicationContext(),data.getStringExtra("data"),Toast.LENGTH_SHORT).show();
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),data.getStringExtra("data"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}