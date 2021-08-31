package com.example.banha_services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.List;

import com.example.banha_services.API.ApiServices;
import com.example.banha_services.API.categoryitem;
import category.categoryAdapter;
import element.ElementActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Animation animSlideUp;
    private DrawerLayout mDrawer;
   private List<categoryitem>Lists;
//    categoryViewModel categoryViewModel;
    private static final String Base_Url="https://banha-services.herokuapp.com/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//     categoryViewModel= ViewModelProviders.of(this).get(com.example.banha_services.ui.categoryViewModel.class);
//     categoryViewModel.getCategory();

        recyclerView = findViewById(R.id.recyclerview);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices apiServices=retrofit.create(ApiServices.class);
        Call<List<categoryitem>>call=apiServices.getCategory();
        call.enqueue(new Callback<List<categoryitem>>() {
            @Override
            public void onResponse(Call<List<categoryitem>> call, Response<List<categoryitem>> response) {
                    Lists=response.body();
                    categoryAdapter adapter=new categoryAdapter(Lists,MainActivity.this);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    recyclerView.setAdapter(adapter);
                    animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.startAnimation(animSlideUp);
            }

            @Override
            public void onFailure(Call<List<categoryitem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void onListItemClick(int position){
       int category_id=Lists.get(position).getId();
        Intent intent=new Intent(this, ElementActivity.class);
        intent.putExtra("category_id",category_id);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_language,menu);
        MenuItem item=menu.findItem(R.id.search);
        androidx.appcompat.widget.SearchView searchView= (androidx.appcompat.widget.SearchView) item.getActionView();
        searchView.setQueryHint("type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
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