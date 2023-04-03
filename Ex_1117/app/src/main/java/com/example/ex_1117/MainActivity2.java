package com.example.ex_1117;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btn_r, btn_g, btn_b;
    ConstraintLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_r = findViewById(R.id.btn_r);
        btn_g = findViewById(R.id.btn_g);
        btn_b = findViewById(R.id.btn_b);
        layout2 = findViewById(R.id.layout2);

        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout2.setBackgroundColor(Color.RED);
            }
        });
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout2.setBackgroundColor(Color.GREEN);
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout2.setBackgroundColor(Color.BLUE);
            }
        });
    }
}