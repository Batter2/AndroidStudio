package com.example.ex_1123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // View 선언(변수 선언)
    Button btn_web, btn_camera, btn_dial, btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View id 값 찾아오기
        btn_web=findViewById(R.id.btn_web);
        btn_camera=findViewById(R.id.btn_camera);
        btn_dial=findViewById(R.id.btn_dial);
        btn_call=findViewById(R.id.btn_call);

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼이 눌리면 web을 사용할 수 있는 화면으로 이동

                // Intent : 객체를 생성하여 이동하거나 실행하고 싶은 action 연결하는 기능
                // ex) new Intent(액션, 주소값)
                Uri uri = Uri.parse("https://www.naver.com");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                // intent를 실행할 수 있는 명령!
                startActivity(intent);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-3624-4740");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:010-3624-4740"));

                // 실제 androidManifest에 권한이 있는지 없는지 확인작업이 필요함
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED){
                    // 만약 권한에 대한 내용이 지정되지 않았다면
                    // 수동적으로 권한을 받을 수 있도록 진행하기!
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},0);
                }

                startActivity(intent);
            }
        });
    }
}