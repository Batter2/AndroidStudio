package com.example.ex_1201;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tv_result;
    RequestQueue requestQueue;
    Button btn;
    EditText address;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.tv_result);
        btn = findViewById(R.id.btn);
        address = findViewById(R.id.address);

        // requestQueue 요청을 보낼 수 있는 기능 담아주기!
        // 현재 페이지인 MainActivity에서 보낼 수 있도록
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String movieUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
                // Volley 통신 실습
                // 1. 요청에 대한 정보를 담아줄 객체 만들기
                StringRequest request = new StringRequest(

                        // 정보1 : 어떤 방식으로 통신할껀지
                        Request.Method.GET,

                        // 정보2 : 어디랑 통신 할건지
                        movieUrl,

                        // 정보3 : 통신 성공 리스너
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // response는 String 타입이기 대문에 Json epdlxjrk String 형식으로 받아진다.
                                // ex) {"test":20} ->"{"test":20}"
                                // Json 형식으로 다시 바꿔서 키값을 사용할 수 있음.

                                // response : 요청성공 시 응답데이터를 자동으로 받아옴!!
                                // 데이터를 받아왔는지 확인해보자
                                tv_result.setText(response);
                                // Log.d("result",response.boxOfficeResult.boxofficeType);

                                // 받아온 데이터를 JSON 타입으로 형변환!!
                                try {
                                    JSONObject json = new JSONObject(response);
                                    // getJSONObject 라는 객체를 가져오기.
                                    JSONObject json2 = json.getJSONObject("boxOfficeResult");
                                    // dailyBoxOfficeList 라는 객체 가져오기.
                                    JSONArray json3 = json2.getJSONArray("dailyBoxOfficeList");
                                    // dailyBoxOfficeList 배열에서 그 아래 객체 가져오기
                                    for(int i=0; i<json3.length(); i++){
                                        JSONObject json4 = json3.getJSONObject(i);
                                        String value = json4.getString("movieNm");
                                        Log.d("result",value);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },

                        // 정보4 : 통신 실패 리스너
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );

                // 요청 정보를 requestQueue에 담아서 실행시키기!
                // 아래 명령어가 있어야 제대로 요청되어 실행이 된다!!
                requestQueue.add(request);

            }
        });

    }
}