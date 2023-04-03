package com.example.ex_1206;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    Button btn_join_join;
    EditText edit_join_id, edit_join_pw, edit_join_nick;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(MainActivity2.this);
        }

        btn_join_join = findViewById(R.id.btn_join_join);
        edit_join_id = findViewById(R.id.edit_join_id);
        edit_join_pw = findViewById(R.id.edit_join_pw);
        edit_join_nick = findViewById(R.id.edit_join_nick);

        btn_join_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String join_inputID = edit_join_id.getText().toString();
                String join_inputPW = edit_join_pw.getText().toString();
                String join_inputNICK = edit_join_nick.getText().toString();

                // 가지고 온 edit_id와 edit_pw를 서버로 전송 = 서버로 요청을 보내다.
                // 요청을 보내기 위해서 request 객체, requestQueue가 필요
                String url="http://172.30.1.31:3001/Join";
                StringRequest request = new StringRequest(
                        // 정보1 : 어떤 방식으로 통신할건지
                        Request.Method.POST,

                        // 정보2 : 어디랑 통신할건지
                        url,

                        // 정보3 : 통신이 성공한 경우
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String json = jsonObject.getString("result");
                                    if(json.equals("회원가입 성공")){
                                        Toast.makeText(MainActivity2.this,"회원가입성공",Toast.LENGTH_SHORT).show();
                                        finish();
                                    }else {
                                        Toast.makeText(MainActivity2.this,"회원가입실패",Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Log.d("통신",response);
                                // Toast.makeText(MainActivity.this,"로그인성공",Toast.LENGTH_SHORT).show();
                            }
                        },
                        // 정보4 : 통신이 실패한 경우
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("통신","실패");
                                Toast.makeText(MainActivity2.this,"회원가입실패",Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        // getParams : post 방식으로 데이터를 보낼 때 사용되는 메소드
                        // 데이터를 key -> value 형태로 만들어서 보내겠습니다.
                        Map<String,String> params = new HashMap<String,String>();
                        // params : key-value 형태로 만들어서 저장
                        params.put("id",join_inputID);
                        params.put("pw",join_inputPW);
                        params.put("nick",join_inputNICK);

                        // key-value로 만들어진 params객체를 전송!
                        return params;
                    }
                }; // request 여기까지
                requestQueue.add(request);
            }
        });


    }
}