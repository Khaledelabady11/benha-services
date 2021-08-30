package com.example.banha_services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import category.categoryAdapter;
import category.categoryData;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Animation animSlideUp;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<categoryData> arrayList = new ArrayList<>();
        categoryData data2 = new categoryData();
        data2.setName("Medical");
        data2.setImage(R.drawable.medical);
        categoryData data3 = new categoryData();
        data3.setName("medical");
        data3.setImage(R.drawable.medical);
        categoryData data4 = new categoryData();
        data4.setName("Medical");
        data4.setImage(R.drawable.medical);
        categoryData data5 = new categoryData();
        data5.setName("khaled");
        data5.setImage(R.drawable.medical);
        categoryData data6 = new categoryData();
        data6.setName("khaled");
        data6.setImage(R.drawable.medical);
        categoryData data7 = new categoryData();
        data7.setName("khaled");
        data7.setImage(R.drawable.medical);
        categoryData data8 = new categoryData();
        data8.setName("khaled");
        data8.setImage(R.drawable.medical);
        categoryData data9 = new categoryData();
        data9.setName("khaled");
        data9.setImage(R.drawable.medical);
        categoryData data10 = new categoryData();
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

        recyclerView = findViewById(R.id.recyclerview);
        categoryAdapter adapter = new categoryAdapter(arrayList, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.startAnimation(animSlideUp);

        // Set a Toolbar to replace the ActionBar.



        // This will display an Up icon (<-), we will replace it with hamburger later
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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