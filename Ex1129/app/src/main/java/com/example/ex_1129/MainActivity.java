package com.example.ex_1129;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> dataArray; // 데이터셋
    ArrayAdapter<String> adapter; // Adapter 사용!
    Button btn_add;
    EditText Text_add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xml 파일을 Java에서 사용가능하도록 변환시켜줌
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        btn_add = findViewById(R.id.btn_add);
        Text_add = findViewById(R.id.Text_add);

        // 데이터 저장
        dataArray = new ArrayList<String>();
        dataArray.add("짬뽕밥");
        dataArray.add("깐풍기");
        dataArray.add("깐쇼새우");
        dataArray.add("레드콤보윙봉");
        dataArray.add("치즈감자튀김");
        dataArray.add("장어양념구이");
        dataArray.add("타코야끼");
        dataArray.add("고등어회");
        dataArray.add("제주은갈치구이");
        dataArray.add("매운쭈삼");
        dataArray.add("A++ 살치살");
        dataArray.add("육사시미");
        dataArray.add("아이스티샷추가");
        dataArray.add("수제버거");
        dataArray.add("충만치킨 어니언치킨");
        dataArray.add("도미노피자 페페로니피자");

        // Adapter 역할 : 데이터를 ListView의 항목(=아이템)으로 보여질 수 있도록 변환
        // 현재 페이지의 정보, 어떤 형식(항목)으로 띄워질지, 어떤 데이터를 띄울건지
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,dataArray);

        // Adapter로 만들어진 항목들을 ListView에 적용!
        lv.setAdapter(adapter);

        // ListView 각각의 항목에 클릭이벤트 적용
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // adapterView : 현재 사용하고 있는 adapterView의 속성 ==> ListView 속성
                // View : 클릭한 항목에 대한 객체
                // i : 클릭한 항목의 인덱스
                // l : 클릭한 항목의 ID 값
                Toast.makeText(MainActivity.this,dataArray.get(i),Toast.LENGTH_SHORT).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                adapter.add(Text_add.getText().toString());
                dataArray.add(Text_add.getText().toString());
                lv.setAdapter(adapter);

                // adapter 갱신 -> adapter 내용을 갱신해줌으로써 연결되어있는
                // ListView(AdapterView)에 자동으로 반영 시키는 기능

                // adapter.notifyDataSetInvalidated();

            }
        });



    }
}