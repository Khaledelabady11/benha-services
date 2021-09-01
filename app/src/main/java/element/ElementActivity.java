package element;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.banha_services.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
private SearchView searchView;
private elementAdapter adapter;
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
                adapter=new elementAdapter( firmList, ElementActivity.this);
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
    private void onListItemClick(int position) {
        String phoneNumber = firmList.get(position).getPhone_number();
        callPhone(phoneNumber);
    }

    private void callPhone(String phone_number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:$phoneNumber"));
        startActivity(callIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_language, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.ar)
        {
            setLocale("ar");
            recreate();
            Toast.makeText(this, "Arabic ", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(id==R.id.en)
        {
            setLocale("en");
            recreate();
            Toast.makeText(this, "English ", Toast.LENGTH_LONG).show();
            return true;
        }
        // for share button
        else if(id==R.id.share)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Check Out This Application");
            intent.putExtra(Intent.EXTRA_TEXT,"https://github.com/Khaledelabady11/benha-services ");
            startActivity(intent.createChooser(intent,"Send items to"));
            return true;
        }
        else if(id==R.id.contact)
        {
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "kmohamed9231@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intent.putExtra(Intent.EXTRA_TEXT, "text");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(
                config,getBaseContext().getResources().getDisplayMetrics()
        );
        SharedPreferences.Editor editor = getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}