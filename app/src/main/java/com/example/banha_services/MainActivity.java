package com.example.banha_services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<recyclerData> arrayList=new ArrayList<>();
        recyclerData data2=new recyclerData();
        data2.setName("Medical");
        data2.setImage(R.drawable.medical);
        recyclerData data3=new recyclerData();
        data3.setName("medical");
        data3.setImage(R.drawable.medical);
        recyclerData data4=new recyclerData();
        data4.setName("Medical");
        data4.setImage(R.drawable.medical);
        recyclerData data5=new recyclerData();
        data5.setName("khaled");
        data5.setImage(R.drawable.medical);
        recyclerData data6=new recyclerData();
        data6.setName("khaled");
        data6.setImage(R.drawable.medical);
        recyclerData data7=new recyclerData();
        data7.setName("khaled");
        data7.setImage(R.drawable.medical);
        recyclerData data8=new recyclerData();
        data8.setName("khaled");
        data8.setImage(R.drawable.medical);
        recyclerData data9=new recyclerData();
        data9.setName("khaled");
        data9.setImage(R.drawable.medical);
        recyclerData data10=new recyclerData();
        data10.setName("khaled");
        data10.setImage(R.drawable.medical);
        arrayList.add(data2);
        arrayList.add(data3);
        arrayList.add(data4);
        arrayList.add(data5);
        arrayList.add(data6);
        arrayList.add(data7);
        arrayList.add(data8);
        arrayList.add(data9);
        arrayList.add(data10);

        recyclerView=findViewById(R.id.recycler);
        recyclerAdapter adapter=new recyclerAdapter(arrayList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);


    }
}