package com.kh.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   GridView gridView;
   List<MovieDto> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        setList();
        GridAdapter adapter=new GridAdapter(MainActivity.this,R.layout.view_gridcell,list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieDto dto=list.get(position);
                //this 는 지금 익명 클래스를 가르치기 때문에 사용 x
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                View viewDial=View.inflate(MainActivity.this,R.layout.view_dialog,null);
                ImageView imageView=viewDial.findViewById(R.id.imageViewDial);
                TextView textView =viewDial.findViewById(R.id.textViewDial);
                imageView.setImageResource(dto.getImgId());
                textView.setText(dto.getTitle());
                dialog.setView(viewDial);
                dialog.setNegativeButton("확인",null);
                dialog.show();

            }
        });
    }

    private void setList() {
        for(int i=1; i<=83; i++){
            int imgId=getResources().getIdentifier("mov"+i,"drawable",getPackageName());
            String title="영화제목-"+i;
            MovieDto dto=new MovieDto(imgId,title);
            list.add(dto);
        }
        Log.d("TAG", "setList: "+list.toString());
    }

}