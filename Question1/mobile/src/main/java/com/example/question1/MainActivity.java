package com.example.question1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn1.getText().equals("BUTTON1")){
                    btn1.setText("1ST BUTTON!");
                }else{
                    btn1.setText("BUTTON1");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn2.getText().equals("BUTTON2")){
                    btn2.setText("2ND BUTTON!");
                }else{
                    btn2.setText("BUTTON2");
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn3.getText().equals("BUTTON3")){
                    btn3.setText("3RD BUTTON!");
                }else{
                    btn3.setText("BUTTON3");
                }
            }
        });
    }
}