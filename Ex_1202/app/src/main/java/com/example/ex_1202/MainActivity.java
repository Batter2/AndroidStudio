package com.example.ex_1202;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Context context;
    private int layout;
    private LayoutInflater inflater;

    Button btn;
    TextView movie_name, movie_cnt, movie_date;
    RequestQueue requestQueue;
    ArrayList<Data> dataArray;
    ListView movie_result;
    MyAdapter adapter;
    EditText movie_input;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn = findViewById(R.id.btn);
         movie_result = findViewById(R.id.movie_result);
         movie_input = findViewById(R.id.movie_input);
//        movie_name = findViewById(R.id.movie_name);
//        movie_cnt = findViewById(R.id.movie_cnt);
//        movie_date = findViewById(R.id.movie_date);

        // requestQueue 요청을 보낼 수 있는 기능 담아주기
        // 현재 페이지인 MainActivity에서 보낼 수 있도록
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        dataArray = new ArrayList<Data>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = movie_input.getText().toString();

                String movieUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + input;
                String movieUrl2 = "http://172.30.1.46:3001";

                // 요청 정보 만들기
                StringRequest request = new StringRequest(

                        // 정보1 : 어떤 방식으로 통신할건지
                        Request.Method.GET,

                        // 정보2 : 어디랑 통신할건지
                        movieUrl2,


                        // 정보3 : 통신이 성공한 경우
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("통신","성공");
//                                movie_name.setText(response);
//                                movie_cnt.setText(response);
//                                movie_date.setText(response);

//                                try {
//                                    JSONObject json = new JSONObject(response);
//                                    // getJSONObject 라는 객체를 가져오기.
//                                    JSONObject json2 = json.getJSONObject("boxOfficeResult");
//                                    // dailyBoxOfficeList 라는 객체 가져오기.
//                                    JSONArray json3 = json2.getJSONArray("dailyBoxOfficeList");
//                                    // dailyBoxOfficeList 배열에서 그 아래 객체 가져오기
//
//                                    dataArray.clear();
//
//                                    for (int i = 0; i < json3.length(); i++) {
//                                        JSONObject json4 = json3.getJSONObject(i);
//                                        String value1 = json4.getString("movieNm");
//                                        String value2 = json4.getString("audiCnt");
//                                        String value3 = json4.getString("openDt");
//                                        Log.d("result1",value1);
//                                        Log.d("result2",value2);
//                                        Log.d("result3",value3);
//                                        dataArray.add(new Data(value1,value2,value3));
//                                    }
//
//                                    adapter = new MyAdapter(MainActivity.this,R.layout.movie,dataArray);
//                                    movie_result.setAdapter(adapter);
//                                } catch (JSONException ex) {
//                                    ex.printStackTrace();
//                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("통신","실패");
                            }
                        }
                );
                requestQueue.add(request);
            }
        });
    }

//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        return null;
    }
