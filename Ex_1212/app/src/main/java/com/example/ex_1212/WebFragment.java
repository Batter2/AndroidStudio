package com.example.ex_1212;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web,null);
        WebView myWeb = view.findViewById(R.id.myWeb);
        // 인터넷 권한, url
        myWeb.loadUrl("http://172.30.1.31:5500/Ex01.html");

        return view;
    }
}