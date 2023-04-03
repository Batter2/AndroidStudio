package com.example.ex_1121;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    // 1. View 선언

    TextView tv_result;
    EditText edt_num1, edt_num2;
    Button btn_plus, btn_sub, btn_mul, btn_div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 2. View id값 저장하기

        tv_result = findViewById(R.id.tv_result);

        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);

        btn_div = findViewById(R.id.btn_div);
        btn_mul = findViewById(R.id.btn_mul);
        btn_plus = findViewById(R.id.btn_plus);
        btn_sub = findViewById(R.id.btn_sub);

        // 3. btn 버튼을 클릭했을 때 각 버튼의 기능에 맞춰 연산 진행하기
        // - 이벤트 연결은 클래스를 활용한 이벤트!

        btn_sub.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // 입력된 정수값 가져오기
        int num1 = Integer.parseInt(edt_num1.getText().toString());
        int num2 = Integer.parseInt(edt_num2.getText()+"");
        int result = 0;

        // 4. onClick() 메소드 내에서 사용자가 클릭한 버튼이 어떤 버튼인지 확인하기!
        // - 확인된 버튼에 따라 첫 번째 정수, 두 번째 정수 값을 가져와 연산 진행하기!
        // - 연산에 따른 결과값 tv_result에 띄우기

        if(view.getId()==R.id.btn_plus){
            result = num1 + num2;
        }else if(view.getId()==R.id.btn_sub){
            result = num1>num2? num1-num2 : num2-num1;
        }else if(view.getId()==R.id.btn_mul){
            result = num1 * num2;
        }else if(view.getId()==R.id.btn_div){
            result = num1 / num2;
        }

        // 연산의 결과 tv_result에 연결
        tv_result.setText(result+"");
    }
}