package com.example.ex_1130;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
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
    //Mydapter ->데이터가 항목에 넣어줘서 리스트뷰에 띄우는 역할
    //리스트 뷰가 띄워질 페이지(액티비티)에 대한 정보


    private Context context; //현재 액티비티(화면)의 정보
    //띄워질 항목에 대한 레이아웃 정보


    private  int layout; //리스트뷰에 보여질 항목 레이아웃에 대한 정보
    private ArrayList<Member> dataArray; // 데이터셋
    private LayoutInflater inflater; // xml ->View객체로 변환
    //    추가
    private AlertDialog dialog;

    public MyAdapter(Context context, int layout, ArrayList<Member> dataArray) {
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
//        추가
        SingerViewHolder viewHolder;

        view = inflater.inflate(layout,null);
//        추가
        viewHolder = new SingerViewHolder();
        viewHolder.tv_name = view.findViewById(R.id.tv_name);
        viewHolder.tv_number = view.findViewById(R.id.tv_number);
        viewHolder.img = view.findViewById(R.id.img);
//        추가완료
        ImageView img = view.findViewById(R.id.img);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_number = view.findViewById(R.id.tv_number);
        Button btn = view.findViewById(R.id.btn);

        img.setImageResource(dataArray.get(i).getImg());
        tv_name.setText(dataArray.get(i).getName());
        tv_number.setText(dataArray.get(i).getNumber());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,dataArray.get(i).getName(),Toast.LENGTH_SHORT).show();
                popUpImg(dataArray.get(i).getImg());
            }
        });
//네임 넘버 카운트 랭크
//        추가이벤트
//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "선택 : " + i
//                        + ", 이름 : " + dataArray.get(i).getName(), Toast.LENGTH_SHORT).show();
//                //방법 ① : 이미지뷰 추가하여 직접 붙임
//
//
////                //방법 ② : 미리 만들어둔 XML과 팝업창을 연결해서 보여줌
////                popupImgXml(list.get(position).getResId(), list.get(position).getName());
//            }
//        });

        return view;

    }
    //추가
    public class SingerViewHolder{
        public ImageView img;
        public TextView tv_name, tv_number;

    }
    //추가 클래스
    public void popUpImg(int resId) {
        ImageView image = new ImageView(context);
        image.setImageResource(resId);


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지 띄우기");
        builder.setView(image);
        //setMessage 글 쓸수있는 함수
//    builder.setMessage("글을 써보자");
//    builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialog, int which) {
//            if(dialog != null) {
//                dialog.dismiss();
//            }
//        }
//    });
        builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        dialog = builder.create();
        dialog.show();
    }



}
