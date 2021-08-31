package element;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import com.example.banha_services.R;

import java.util.ArrayList;
import java.util.List;

import Firms.Firmsitem;
import Firms.ApiFirm;
import Firms.Firmsitem;
import category.categoryAdapter;
import element.elementAdapter;
import element.elementData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ElementActivity extends AppCompatActivity {

private  RecyclerView element;
    private static final String Base_Url="https://banha-services.herokuapp.com/api/";
    Animation   animSlideUp;
    private List<Firmsitem> firmList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);
        Intent intent=getIntent();
        int category_id=intent.getIntExtra("id",0);
    element=(RecyclerView) findViewById(R.id.element_recycler);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiFirm apiFirm=retrofit.create(ApiFirm.class);
        Call<List<Firmsitem>>call=apiFirm.getFirm(category_id);
        call.enqueue(new Callback<List<Firmsitem>>() {
            @Override
            public void onResponse(Call<List<Firmsitem>> call, Response<List<Firmsitem>> response) {
                firmList=response.body();
                elementAdapter adapter=new elementAdapter( firmList, ElementActivity.this);
                element.setLayoutManager(new GridLayoutManager(ElementActivity.this, 1));
                element.setAdapter(adapter);
                animSlideUp= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
                element.setVisibility(View.VISIBLE);
                element.startAnimation(animSlideUp);
            }

            @Override
            public void onFailure(Call<List<Firmsitem>> call, Throwable t) {

            }
        });


    }
}