package com.example.banha_services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_language,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setQueryHint("type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.ar)
            Toast.makeText(this,"Arabic ",Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}