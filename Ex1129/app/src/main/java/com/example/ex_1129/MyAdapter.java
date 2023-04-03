package com.example.ex_1129;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// MyAdapter --> 나만의 Adapter(내가 정한 형식으로 ListView에 데이터를 띄워줄 수 있는 Adapter)
// 중요!!!!!!!!! 나만의 Adapter를 만들 때는 BaseAdapter를 상속받아 주어야한다.
public class MyAdapter extends BaseAdapter {

    // 현재 activity의 정보
    private Context context;

    // ListView에 보여질 항목 Layout에 대한 정보
    private int layout;

    // 이미지의 타입은 int, 데이터셋
    private ArrayList<Member> dataArray;

    // xml -> View 객체로 변환
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, ArrayList<Member> dataArray) {
        this.context = context;
        this.layout = layout;
        this.dataArray = dataArray;

        // xml --> view 객체로 만들 수 있는 기능을 받아옴!!

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // 데이터 셋에 있는 데이터의 갯수를 반환
        return dataArray.size();
    }

    @Override
    public Object getItem(int i) {
        // 데이터에 접근
        return dataArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        // 항목의 ID값을 반환
        return i;
    }

    // ★★★★★★★0
    // ListView의 항목에 들어갈 내용을 초기화해주는 역할
    // 항목을 ListView에 표현할 수 있도록 그려주는(준비하는) 역할
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // my_item.xml을 가지고 와서 데이터를 담아준 다음에 ListView로 출력 시켜주어야함!

        // layout에 저장되어있는 my_item.xml을 Java에서 사용할 수 있도록
        // view 객체로 변환하겠습니다.
        view = inflater.inflate(layout,null);

        // findViewById 앞에 view.가 들어가는 이유 : java의 메소드와 비슷
        ImageView img = view.findViewById(R.id.img);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_num = view.findViewById(R.id.tv_num);

        img.setImageResource(dataArray.get(i).getImg());
        tv_name.setText(dataArray.get(i).getName());
        tv_num.setText(dataArray.get(i).getNumber());

        return view;
    }
}
