package com.example.ex_1212;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class StarFragment extends Fragment {

    Button btn_star;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_star, container, false);

        // 프래그먼트의 요소에 기능을 달아 줄 때는
        // 프래그먼트화면(xml)을 Java(View객체)로 변환시켜주는 작업이 필요하다. ==> inflater을 사용
       View btn_view = inflater.inflate(R.layout.fragment_star,container,false);
       Button btn_star = btn_view.findViewById(R.id.btn_star);
       Log.d("위치 찾아보기", "1");

        btn_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("위치 찾아보기", "2");
                Toast.makeText(getActivity(), "STAR",Toast.LENGTH_SHORT).show();
                Log.d("위치 찾아보기", "3");
            }
        });

        return btn_view;
    }
}