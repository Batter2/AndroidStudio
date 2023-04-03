package com.example.ex_1202;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Data> dataArray;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, ArrayList<Data> dataArray) {
        this.context = context;
        this.layout = layout;
        this.dataArray = dataArray;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return dataArray.size();
    }

    @Override
    public Object getItem(int i) {
        return dataArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(layout, null);
        TextView movie_name = view.findViewById(R.id.movie_name);
        TextView movie_cnt = view.findViewById(R.id.movie_cnt);
        TextView movie_date = view.findViewById(R.id.movie_date);

        movie_name.setText(dataArray.get(i).getMovie_name());
        movie_cnt.setText(dataArray.get(i).getMovie_cnt());
        movie_date.setText(dataArray.get(i).getMovie_date());


        return view;
    }
}
