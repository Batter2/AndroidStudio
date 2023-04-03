package com.example.ex_1130;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Button btn;

    // Context의 역할
    // 1. 시스템이 관리하고 있는 정보에 접근할 수 있는 것 -> 리소드나 클래스에 접근할 수 있음
    // 1-1. 애플리케이션 또는 액티비티에 대한 포괄적인 정보를 지니고 있는 객체
    // 2. 자신이 어떤 애플리케이션을 나타내고 있는지 알려주는 ID역할
    // 3. ActivityManagerService에 접근할 수 있도록 하는 통로역할

    // MyAdapterr -> 데이터를 항목에 넣어줘서 ListView에 띄우는 역할
    // 어떤 페이지에 있는 ListView인지 알아야함, ListView가 띄워질때 페이지에 대한 정보
    private Context context;

    // Layout
    // 1. View를 예쁘게 담아주는 역할
    // 2. Layout마다 성질이 달라서 구상한것에 맞게 구현하려면 성질을 파악해야함

    // 띄워질 항목에 대한 레이아웃 정보
    private int layout;

    // 데이터 셋
    private ArrayList<Data> dataArray;

    // inflater
    // xml 코드들을 객체화해서 코드에서 사용하기 위함함

    // xml -> Java에서 사용가능하게끔 view로 변환 시켜주는 기능
    // 자동으로 생성된 xml이 아닌 유저가 만든 xml을 객체화 시키기 위해서 inflater이 필요함
    private LayoutInflater inflater;

    // adapter의 역할
    // 1. 실제 데이터 관리를 하고 실제 데이터에서 View를 만들어주는 역할
    // 2. 데이터와 ListView 사이의 통신을 위한 다리 역할

    // adapter은 adapterview가 출력할 수 있는 데이터를 만들어 놓는 공간이고,
    // adapterview는 이 데이터를 출력하는 역할을 한다.

    public MyAdapter(Context context, int layout, ArrayList<Data> dataArray){
        this.context = context;
        this.layout = layout;
        this.dataArray = dataArray;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        // 데이터 셋에 있는 데이터의 갯수
        return dataArray.size();
    }

    @Override
    public Object getItem(int i) {

        // 데이터에 접근
        return dataArray.get(i);
    }

    @Override
    public long getItemId(int i) {

        // 항목(item)의 아이디값
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // ListView 들어갈 항목을 실질적으로 띄워주는 역할

        // 항목을 사용할 수 있도록 가져오기기
        view = inflater.inflate(layout,null);

        // 데이터를 항목안에 있는 각각의 View에 띄우기
        ImageView img = view.findViewById(R.id.img);
        TextView item_name = view.findViewById(R.id.item_name);
        TextView item_ctn = view.findViewById(R.id.item_ctn);

        img.setImageResource(dataArray.get(i).getImg());
        item_name.setText(dataArray.get(i).getName());
        item_ctn.setText(dataArray.get(i).getCnt());

        btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,item_name.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
