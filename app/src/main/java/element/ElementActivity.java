package element;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.banha_services.R;

import java.util.ArrayList;
import java.util.List;

import category.categoryAdapter;
import category.categoryData;
import element.elementAdapter;
import element.elementData;

public class ElementActivity extends AppCompatActivity {

private  RecyclerView element;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosptal);

    List<elementData> arrayList = new ArrayList<>();
    elementData data2 = new elementData();
    data2.setName("Medical");
    data2.setPhone_number("01206458433");
   data2.setDesc("hdhhdhd");
   data2.setAddress("sdsd");
    arrayList.add(data2);

    element=(RecyclerView) findViewById(R.id.element_recycler);
    elementAdapter arrAdapter=new elementAdapter(arrayList,this);
    element.setLayoutManager(new GridLayoutManager(this,1));
    element.setAdapter(arrAdapter);


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_language,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView =(androidx.appcompat.widget.SearchView) item.getActionView();
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